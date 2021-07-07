package service.impl;

import model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import service.PostService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {


    private static final Long id = 1L;
    private static final String content = "content";
    private static final LocalDateTime created = LocalDateTime.now();
    private static final LocalDateTime updated = LocalDateTime.now();

    private static final Post postCreate = new Post(content, created);
    private static final Post postUpdated = new Post(id, content, updated);

    @Mock
    private Post post;

    @Mock
    private List<Post> postList;

    @Spy
    private PostService postService;


    @Before
    public void setUp() {
        String str = "Just string";
        when(post.getContent()).thenReturn(str);
    }


    @Test
    public void getContentTest() {
        assertEquals("Just string", post.getContent());
    }


    @Test
    public void createTest() {
        doReturn(postCreate).when(postService).create(content, created);
        assertEquals(postCreate, postService.create(content, created));
    }


    @Test
    public void updateTest() {
        doReturn(postUpdated).when(postService).update(1L, content, updated);
        assertEquals(postUpdated, postService.update(1L, content, updated));
    }


    @Test
    public void getAllTest() {
        doReturn(postList).when(postService).getAll();
        assertEquals(postList, postService.getAll());
    }

}
