package service.impl;

import model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import service.PostService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {


    private static final Long id = 1L;
    private static final String content = "content";
    private static final Long writerId = 2L;

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
        doReturn(post).when(postService).create(writerId, content);
        assertEquals(post, postService.create(2L,content));
    }


    @Test
    public void updateTest() {
        doReturn(post).when(postService).update(id,   2L, content);
        assertEquals(post, postService.update(1L, writerId, content ));
    }


    @Test
    public void getAllTest() {
        doReturn(postList).when(postService).getAll();
        assertEquals(postList, postService.getAll());
    }

}
