import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSendTest{
    @Test
    public void ruMessageSenderTest(){
        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Mockito.any())).thenReturn("Добро пожаловать");

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(Mockito.any())).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationServiceImpl);
        Assertions.assertEquals("Добро пожаловать",messageSender.send(headers));
    }

    @Test
    public void engMessageSenderTest(){
        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Mockito.any())).thenReturn("Welcome");

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(Mockito.any())).thenReturn(new Location("New York", Country.USA, null,  0));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "92.123.12.19");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationServiceImpl);
        Assertions.assertEquals("Welcome",messageSender.send(headers));
    }
}
