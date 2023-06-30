package rentacar.common_lib.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rentacar.common_lib.model.enumeration.Currency;
import rentacar.common_lib.model.enumeration.TypeOfPriceListItem;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PriceListItemTest {

    private PriceListItem priceListItem;

    @BeforeEach
    public void setUp() {
        priceListItem = new PriceListItem();
    }

    @AfterEach
    public void tearDown() {
        priceListItem = null;
    }

    @Test
    public void testPriceListItemConstructor() {
        assertNull(priceListItem.getId());
        assertNull(priceListItem.getPriceList());
        assertNull(priceListItem.getPrice());
        assertNull(priceListItem.getPdv());
        assertNull(priceListItem.getTypeOfPriceListItem());
        assertNull(priceListItem.getCurrency());
        assertNull(priceListItem.getTypeOfVehicle());
    }

    @Test
    public void testGetPriceList() {
        assertNull(priceListItem.getPriceList());
    }

    @Test
    public void testSetPriceList() {
        PriceList priceList = new PriceList();
        priceListItem.setPriceList(priceList);
        assertEquals(priceList, priceListItem.getPriceList());
    }

    @Test
    public void testGetPrice() {
        assertNull(priceListItem.getPrice());
    }

    @Test
    public void testSetPrice() {
        BigDecimal price = BigDecimal.valueOf(100);
        priceListItem.setPrice(price);
        assertEquals(price, priceListItem.getPrice());
    }

    @Test
    public void testSetPriceWithNull() {
        assertThrows(NullPointerException.class, () -> {
            priceListItem.setPrice(null);
        });
    }

    @Test
    public void testSetPriceWithNegativeValue() {
        BigDecimal price = BigDecimal.valueOf(-100);
        assertThrows(IllegalArgumentException.class, () -> {
            priceListItem.setPrice(price);
        });
    }

    @Test
    public void testGetPdv() {
        assertNull(priceListItem.getPdv());
    }

    @Test
    public void testSetPdv() {
        PDV pdv = new PDV();
        priceListItem.setPdv(pdv);
        assertEquals(pdv, priceListItem.getPdv());
    }

    @Test
    public void testSetPdvWithNull() {
        assertThrows(NullPointerException.class, () -> {
            priceListItem.setPdv(null);
        });
    }

    @Test
    public void testGetTypeOfPriceListItem() {
        assertNull(priceListItem.getTypeOfPriceListItem());
    }

    @Test
    public void testSetTypeOfPriceListItem() {
        TypeOfPriceListItem typeOfPriceListItem = TypeOfPriceListItem.PERDAY;
        priceListItem.setTypeOfPriceListItem(typeOfPriceListItem);
        assertEquals(typeOfPriceListItem, priceListItem.getTypeOfPriceListItem());
    }

    @Test
    public void testSetTypeOfPriceListItemWithNull() {
        assertThrows(NullPointerException.class, () -> {
            priceListItem.setTypeOfPriceListItem(null);
        });
    }

    @Test
    public void testGetCurrency() {
        assertNull(priceListItem.getCurrency());
    }

    @Test
    public void testSetCurrency() {
        Currency currency = Currency.EUR;
        priceListItem.setCurrency(currency);
        assertEquals(currency, priceListItem.getCurrency());
    }

    @Test
    public void testSetCurrencyWithNull() {
        assertThrows(NullPointerException.class, () -> {
            priceListItem.setCurrency(null);
        });
    }

    @Test
    public void testGetTypeOfVehicle() {
        assertNull(priceListItem.getTypeOfVehicle());
    }

    @Test
    public void testSetTypeOfVehicle() {
        TypeOfVehicle typeOfVehicle = new TypeOfVehicle();
        priceListItem.setTypeOfVehicle(typeOfVehicle);
        assertEquals(typeOfVehicle, priceListItem.getTypeOfVehicle());
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false"
    })
    public void testEquals(Long id1, Long id2, boolean expected) {
        PriceListItem priceListItem1 = new PriceListItem();
        PriceListItem priceListItem2 = new PriceListItem();
        priceListItem1.setId(id1);
        priceListItem2.setId(id2);
        assertEquals(expected, priceListItem1.equals(priceListItem2));
    }
}
