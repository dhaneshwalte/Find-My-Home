package com.project.group17.listingsTest;
import com.project.group17.user.entity.User;
import com.project.group17.listings.entity.ListingsEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ListingsEntityTest {
    private ListingsEntity listingsEntity;
    private User user;

    @BeforeEach
    public void setUp() {
        user = mock(User.class);
        Mockito.when(user.getId()).thenReturn(1);
        Mockito.when(user.getUsername()).thenReturn("testUser");
        listingsEntity = new ListingsEntity();
        listingsEntity.setListingId(1L);
        listingsEntity.setType("3BHK Apartment");
        listingsEntity.setAddress("123 Tobin St");
    }

    @Test
    public void testListingId() {
        assertEquals(1L, listingsEntity.getListingId());
    }
    @Test
    public void testType() {
        assertEquals("3BHK Apartment", listingsEntity.getType());
    }

    @Test
    public void testAddress() {
        assertEquals("123 Tobin St", listingsEntity.getAddress());
    }


}
