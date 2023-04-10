import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    @Test
    public void byIpTest(){
        GeoServiceImpl geoService = new GeoServiceImpl();
        String ip = "172.123.12.19";
        Country expected = Country.RUSSIA;

        Country preferences = geoService.byIp(ip).getCountry();

        Assertions.assertEquals(expected,preferences);
    }
}
