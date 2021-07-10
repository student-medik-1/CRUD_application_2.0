package service.impl;

import model.Region;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import service.RegionService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegionServiceImplTest {


    private static final Long id = 1L;
    private static final String regionName = "Barcelona";
    private static final Long writerId = 3L;

    @Mock
    private Region region;

    @Mock
    private List<Region> regionList;

    @Spy
    private RegionService regionService;


    @Before
    public void setUp() {
        String str = "Canada";
        when(region.getRegionName()).thenReturn(str);
    }


    @Test
    public void getRegionTest() {
        assertEquals("Canada", region.getRegionName());
    }


    @Test
    public void createTest() {
        doReturn(region).when(regionService).create("Barcelona",writerId);
        assertEquals(region, regionService.create(regionName, 3L));
    }


    @Test
    public void updateTest() {
        doReturn(region).when(regionService).update(id,"Barcelona", 3L);
        assertEquals(region, regionService.update(1L, "Barcelona", writerId));
    }


    @Test
    public void getAllTest() {
        doReturn(regionList).when(regionService).getAll();
        assertEquals(regionList, regionService.getAll());
    }

}
