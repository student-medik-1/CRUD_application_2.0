package service.impl;

import model.Region;
import model.Writer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import repository.WriterRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WriterServiceImplTest {



    private static final Long id = 1L;
    private static final String first = "Sergey";
    private static final String last = "Dovlatov";

    private static final Region regionName = new Region("Canada");
    private static final Writer writerCreate = new Writer(first, last, regionName);
    private static final Writer writerUpdate = new Writer(id, first, last, regionName);


    @Mock
    private Writer writer;

    @Mock
    private List<Writer> writerList;

    @Mock
    private WriterRepository writerRepository;

    @Spy
    private final WriterServiceImpl writerService = new WriterServiceImpl(writerRepository);

    @Before
    public void setUp() {

        String firstName = "Viktor";
        String lastName = "Pelevin";

        when(writer.getFirstName()).thenReturn(firstName);
        when(writer.getLastName()).thenReturn(lastName);
    }


    @Test
    public void getWriterTest() {
        assertEquals("Viktor", writer.getFirstName());
        assertEquals("Pelevin", writer.getLastName());
    }


    @Test
    public void createTest() {
        doReturn(writerCreate).when(writerService).create("Sergey", "Dovlatov",
                new Region("Canada"));
        //assertEquals(writerCreate, writerService.create("Sergey", "Dovlatov", regionName));
    }


    @Test
    public void updateTest() {
        doReturn(writerUpdate).when(writerService).update(1L, "Sergey", "Dovlatov",
                new Region("Canada"));
        //assertEquals(writerUpdate, writerService.update(id, first, last, regionName));
    }

    @Test
    public void getAllTest() {
        doReturn(writerList).when(writerService).getAll();
        assertEquals(writerList, writerService.getAll());
    }

}
