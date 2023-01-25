package com.demo2.demo.service;

import com.demo2.demo.model.Post;
import com.demo2.demo.model.User;
import com.demo2.demo.repository.PostRepository;
import com.demo2.demo.repository.UserRepository;
import com.demo2.demo.util.ResponseDto;
import com.demo2.demo.util.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;


    @Autowired
    private ResponseService responseService;

    @Override
    public ResponseDto list() {
        try {
            System.out.println("List Request");
            //check current user login
//            fetch data of the user

            List<Post> posts = postRepository.findAll();
            if (posts != null) {
                System.out.println(posts);
                System.out.println("List");
                return this.responseService.formulateResponseDto(posts, "", HttpStatus.OK.value(), true);
            }
            System.out.println("No data");
            return this.responseService.formulateResponseDto(posts, "", HttpStatus.OK.value(), true);
        } catch (Exception exception) {
            return responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.BAD_REQUEST.value(), false);
        }

    }

    @Override
    public ResponseDto save(Post post) {
        try {

            Post post1 = postRepository.save(post);
            return this.responseService.formulateResponseDto(post1, "Successfully Created Post", HttpStatus.OK.value(), true);

        } catch (Exception exception) {

            return this.responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        }
    }

    @Override
    public ResponseDto update(Long id, Post post) {
        try {
            boolean post1 = postRepository.existsById(id);
            if (post1) {
                Post post2 = new Post();
                post2.setId(id);
                post2.setDescription(post.getDescription());
                post2.setTitle(post.getTitle());
                return this.responseService.formulateResponseDto(postRepository.save(post2), "Successfully Updated Post Details", HttpStatus.OK.value(), true);
            }
            return this.responseService.formulateResponseDto(null, "Post not found with Title :" + post.getTitle() + "", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        } catch (Exception exception) {
            return this.responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        }

    }

    @Override
    public ResponseDto delete(Long id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post != null) {
                postRepository.deleteById(id);
                return this.responseService.formulateResponseDto(null, "Post Deleted Successfully", HttpStatus.OK.value(), true);
            }
        } catch (Exception exception) {
            return this.responseService.formulateResponseDto(null, "Found no Post with the Id" + id + "", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);

        }
        return this.responseService.formulateResponseDto(null, "n Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
    }
}
