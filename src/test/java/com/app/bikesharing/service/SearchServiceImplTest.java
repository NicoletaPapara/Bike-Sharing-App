package com.app.bikesharing.service;

import com.app.bikesharing.dao.AddBikeDAO;
import com.app.bikesharing.dao.OrderDAO;
import com.app.bikesharing.dto.BikeOrderDto;
import com.app.bikesharing.exceptions.InvalidDatesException;
import com.app.bikesharing.exceptions.NoAvailableBikesException;
import com.app.bikesharing.exceptions.NoBikesFoundException;
import com.app.bikesharing.model.Bike;
import com.app.bikesharing.model.BikeType;
import com.app.bikesharing.model.Order;
import com.app.bikesharing.model.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class SearchServiceImplTest {

    private SearchServiceImpl searchService;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    private List<Bike> bikes = Arrays.asList(new Bike(1, BikeType.MOUNTAIN, Size.CHILD));

    private List<Bike> bikes1 = Arrays.asList(new Bike(2, BikeType.MOUNTAIN, Size.CHILD),
            new Bike(3, BikeType.MOUNTAIN, Size.CHILD));


    private List<Order> orders = Arrays.asList(new Order(1, LocalDate.of(2019, 8, 12), LocalDate.of(2019, 8, 14)),
            new Order(1, LocalDate.of(2019, 8, 2), LocalDate.of(2019, 8, 2)),
            new Order(1, LocalDate.of(2019, 8, 22), LocalDate.of(2019, 8, 23)));

    private List<Order> orders1 = Arrays.asList(
            new Order(2, LocalDate.of(2019, 8, 24), LocalDate.of(2019, 8, 25)),
            new Order(2, LocalDate.of(2019, 8, 2), LocalDate.of(2019, 8, 2)),
            new Order(2, LocalDate.of(2019, 8, 22), LocalDate.of(2019, 8, 23)));
    private List<Order> orders2 = Arrays.asList(
            new Order(3, LocalDate.of(2019, 8, 22), LocalDate.of(2019, 8, 23)),
            new Order(3, LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 29)),
            new Order(3, LocalDate.of(2019, 8, 13), LocalDate.of(2019, 8, 13)));

    @Mock
    private AddBikeDAO bikeRepository;

    @Mock
    private OrderDAO orderDAO;

    @BeforeEach
    public void setUp() {
        searchService = new SearchServiceImpl(bikeRepository, orderDAO);
    }

    @Test
    void shouldThrowExceptionWhenEndDateBeforeStartDate() throws ParseException {

        Date startDate = dateFormatter.parse("08-09-2019");
        Date endDate = dateFormatter.parse("06-09-2019");
        BikeOrderDto bikeOrderDto = new BikeOrderDto(startDate, endDate);
        Assertions.assertThrows(InvalidDatesException.class, () -> searchService.findAvailableBikes(bikeOrderDto));
    }

    @Test
    void shouldThrowExceptionWhenThereAreNoBikesOfSelectedTypeAndSize() {
        doReturn(null).when(bikeRepository).findByTypeAndSize(any(BikeType.class), any(Size.class));
        Assertions.assertThrows(NoBikesFoundException.class, () -> searchService.findAvailableBikes(new BikeOrderDto(BikeType.MOUNTAIN, Size.CHILD, dateFormatter.parse("08-09-2019"), dateFormatter.parse("09-09-2019"))));
    }

    @Test
    void shouldReturnListOfBikesWhenDatesAreAvailable() throws ParseException, NoBikesFoundException, InvalidDatesException, NoAvailableBikesException {
        Date startDate = dateFormatter.parse("07-08-2019");
        Date endDate = dateFormatter.parse("08-08-2019");
        BikeOrderDto bikeOrderDto = new BikeOrderDto(BikeType.MOUNTAIN, Size.CHILD, startDate, endDate);

        doReturn(bikes).when(bikeRepository).findByTypeAndSize(any(BikeType.class), any(Size.class));
        doReturn(orders).when(orderDAO).findByBikeId(any(Integer.class));

        List<Bike> result = searchService.findAvailableBikes(bikeOrderDto);

        Assertions.assertEquals(result, bikes);
    }

    @Test
    void shouldReturnEmptyListWhenDatesAreNotAvailable() throws ParseException, NoBikesFoundException, InvalidDatesException, NoAvailableBikesException {
        Date startDate = dateFormatter.parse("02-08-2019");
        Date endDate = dateFormatter.parse("02-08-2019");
        BikeOrderDto bikeOrderDto = new BikeOrderDto(BikeType.MOUNTAIN, Size.CHILD, startDate, endDate);

        doReturn(bikes).when(bikeRepository).findByTypeAndSize(any(BikeType.class), any(Size.class));
        doReturn(orders).when(orderDAO).findByBikeId(any(Integer.class));

        List<Bike> result = searchService.findAvailableBikes(bikeOrderDto);

        Assertions.assertEquals(0, result.size());
    }

    @Test
    void shouldReturnAvailableBikesFromAListOfSelectedBikes() throws ParseException, NoBikesFoundException, InvalidDatesException, NoAvailableBikesException {
        Date startDate = dateFormatter.parse("02-08-2019");
        Date endDate = dateFormatter.parse("02-08-2019");
        BikeOrderDto bikeOrderDto = new BikeOrderDto(BikeType.MOUNTAIN, Size.CHILD, startDate, endDate);

        doReturn(bikes1).when(bikeRepository).findByTypeAndSize(any(BikeType.class), any(Size.class));
        doReturn(orders1).when(orderDAO).findByBikeId(2);
        doReturn(orders2).when(orderDAO).findByBikeId(3);

        List<Bike> result = searchService.findAvailableBikes(bikeOrderDto);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void shouldReturnAllSelectedBikesWhenAllAreAvailable() throws ParseException, NoBikesFoundException, InvalidDatesException, NoAvailableBikesException {
        Date startDate = dateFormatter.parse("01-09-2019");
        Date endDate = dateFormatter.parse("05-09-2019");
        BikeOrderDto bikeOrderDto = new BikeOrderDto(BikeType.MOUNTAIN, Size.CHILD, startDate, endDate);

        doReturn(bikes1).when(bikeRepository).findByTypeAndSize(any(BikeType.class), any(Size.class));
        doReturn(orders1).when(orderDAO).findByBikeId(2);
        doReturn(orders2).when(orderDAO).findByBikeId(3);

        List<Bike> result = searchService.findAvailableBikes(bikeOrderDto);
        Assertions.assertEquals(2, result.size());
    }
}