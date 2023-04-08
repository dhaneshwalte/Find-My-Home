//package com.project.group17.location.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.project.group17.location.entity.LocationEntity;
//import com.project.group17.location.repository.LocationRepository;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class LocationServiceTest {
//
//    @Autowired
//    private LocationRepository locationRepository;
//
//    @Autowired
//    private LocationService locationService;
//
//    @BeforeEach
//    public void setUp() {
//        // Add some test data
//        locationRepository.save(new LocationEntity("Test City 1", "10.0", "20.0"));
//        locationRepository.save(new LocationEntity("Test City 2", "30.0", "40.0"));
//    }
//
//    @AfterEach
//    public void tearDown() {
//        testEntityManager.clear();
//    }
//
//    @Test
//    public void testAddDefaultLocations() {
//        locationService.addDefaultLocations();
//        assertNotNull(locationRepository.findByCity("Test City 1"));
//    }
//
//    @Test
//    public void testGetLocationEntity() {
//        LocationEntity location = locationService.getLocationEntity("Test City 3");
//        assertNotNull(location);
//        assertEquals("Test City 3", location.getCity());
//        assertEquals("10.0", location.getLatitude());
//        assertEquals("20.0", location.getLongitude());
//    }
//
//    @Test
//    public void testGetLocationEntityWithNonExistentCity() {
//        LocationEntity location = locationService.getLocationEntity("Non-Existent City");
//        assertNull(location);
//    }
//}
