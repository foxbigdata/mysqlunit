package com.mysqljooq.assetmanageunit;

import com.mysqljooq.assetmanageunit.jooq.domain.tables.pojos.Comments;
import com.mysqljooq.assetmanageunit.jooq.domain.tables.pojos.Posts;

import com.mysqljooq.assetmanageunit.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetManageUnitApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	private BlogService blogService;

	@Test
	public void findAllPosts()  {
		List<Posts> posts = blogService.getAllPosts();
		assertNotNull(posts);
		assertTrue(!posts.isEmpty());
		for (Posts post : posts)
		{
			System.err.println(post);
		}
	}

	@Test
	public void findPostById()  {
		Posts post = blogService.getPost(1);
		assertNotNull(post);
		System.out.println(post);
		List<Comments> comments = post.getComments();
		System.out.println(comments);

	}

	@Test
	public void createPost() {
		Posts post = new Posts(0, "My new Post",
				"This is my new test post",
				new Timestamp(System.currentTimeMillis()));
		Posts savedPost = blogService.createPost(post);
		Posts newPost = blogService.getPost(savedPost.getId());
		assertEquals("My new Post", newPost.getTitle());
		assertEquals("This is my new test post", newPost.getContent());
	}

	@Test
	public void createComment() {
		Integer postId = 1;
		Comments comment = new Comments(0, postId, "User4",
				"user4@gmail.com", "This is my new comment on post1",
				new Timestamp(System.currentTimeMillis()));
		Comments savedComment = blogService.createComment(comment);
		Posts post = blogService.getPost(postId);
		List<Comments> comments = post.getComments();
		assertNotNull(comments);
		for (Comments comm : comments)
		{
			if(savedComment.getId() == comm.getId()){
				assertEquals("User4", comm.getName());
				assertEquals("user4@gmail.com", comm.getEmail());
				assertEquals("This is my new comment on post1", comm.getContent());
			}
		}

	}


}
