package com.mysqljooq.assetmanageunit.service;

import com.mysqljooq.assetmanageunit.jooq.domain.tables.pojos.Comments;
import com.mysqljooq.assetmanageunit.jooq.domain.tables.pojos.Posts;
import com.mysqljooq.assetmanageunit.jooq.domain.tables.records.CommentsRecord;
import com.mysqljooq.assetmanageunit.jooq.domain.tables.records.PostsRecord;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import static com.mysqljooq.assetmanageunit.jooq.domain.Tables.*;


@Service
@Transactional
public class BlogService {

    @Autowired
    private DSLContext dsl;




    public Posts createPost(Posts post){
        PostsRecord postsRecord = dsl.insertInto(POSTS)
                .set(POSTS.TITLE, post.getTitle())
                .set(POSTS.CONTENT, post.getContent())
                .set(POSTS.CREATED_ON, post.getCreatedOn())
                .returning(POSTS.ID)
                .fetchOne();

        post.setId(postsRecord.getId());
        return post;
    }

    public List<Posts> getAllPosts(){
        List<Posts> posts = new ArrayList<>();
        Result<Record> result = dsl.select().from(POSTS).fetch();
        for (Record r : result) {
            posts.add(getPostEntity(r));
        }
        return posts ;
    }

    public Posts getPost(Integer postId){
        Record record = dsl.select().
                from(POSTS)
                .where(POSTS.ID.eq(postId))
                .fetchOne();
        if(record != null)
        {
            Posts post = getPostEntity(record);

            Result<Record> commentRecords = dsl.select().
                    from(COMMENTS)
                    .where(COMMENTS.POST_ID.eq(postId))
                    .fetch();

            for (Record r : commentRecords) {
                post.addComment(getCommentEntity(r));
            }
            return post;
        }
        return null;
    }


    public Comments createComment(Comments comments){
        CommentsRecord commentsRecord = dsl.insertInto(COMMENTS)
                .set(COMMENTS.POST_ID, comments.getId())
                .set(COMMENTS.NAME, comments.getName())
                .set(COMMENTS.EMAIL, comments.getEmail())
                .set(COMMENTS.CONTENT, comments.getContent())
                .set(COMMENTS.CREATED_ON, comments.getCreatedOn())
                .returning(COMMENTS.ID)
                .fetchOne();

        comments.setId(commentsRecord.getId());
        return comments;
    }

    public void deleteComment(Integer commentId){
        dsl.deleteFrom(COMMENTS)
                .where(COMMENTS.ID.equal(commentId))
                .execute();
    }

    private Posts getPostEntity(Record r){
        Integer id = r.getValue(POSTS.ID, Integer.class);
        String title = r.getValue(POSTS.TITLE, String.class);
        String content = r.getValue(POSTS.CONTENT, String.class);
        Timestamp createdOn = r.getValue(POSTS.CREATED_ON, Timestamp.class);
        return new Posts(id, title, content, createdOn);
    }

    private Comments getCommentEntity(Record r) {
        Integer id = r.getValue(COMMENTS.ID, Integer.class);
        Integer postId = r.getValue(COMMENTS.POST_ID, Integer.class);
        String name = r.getValue(COMMENTS.NAME, String.class);
        String email = r.getValue(COMMENTS.EMAIL, String.class);
        String content = r.getValue(COMMENTS.CONTENT, String.class);
        Timestamp createdOn = r.getValue(COMMENTS.CREATED_ON, Timestamp.class);
        return new Comments(id, postId, name, email, content, createdOn);
    }

}
