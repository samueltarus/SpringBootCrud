package com.demo2.demo.service;

import com.demo2.demo.model.Comment;
import com.demo2.demo.model.Post;
import com.demo2.demo.repository.CommentRepository;
import com.demo2.demo.util.ResponseDto;
import com.demo2.demo.util.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ResponseService responseService;

    @Override
    public ResponseDto list() {
        try {
            List<Comment> comments =  commentRepository.findAll();
            return this.responseService.formulateResponseDto(comments, "", HttpStatus.OK.value(), true);
        }
        catch (Exception exception){
            return responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        }

    }

    @Override
    public ResponseDto save(Comment comment) {
        try {
            Comment comment1=  commentRepository.save(comment);
            return this.responseService.formulateResponseDto(null, "Successfully Created Comment", HttpStatus.OK.value(), true);
        } catch (Exception exception) {

            return this.responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.BAD_REQUEST.value(), false);
        }
    }

    @Override
    public ResponseDto update(Long id, Comment comment) {
        try {
            boolean post1 = commentRepository.existsById(id);
            if (post1) {
                Comment comment1 = new Comment();
                comment1.setId(id);
                comment1.setDescription(comment.getDescription());
                comment1.setRate(comment.getRate());
                return this.responseService.formulateResponseDto(commentRepository.save(comment1), "Successfully Updated Comment Details", HttpStatus.OK.value(), true);
            }
            return this.responseService.formulateResponseDto(null, "Comment not found with Title :" + comment.getDescription() + "", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        } catch (Exception exception) {
            return this.responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        }

    }

    @Override
    public ResponseDto delete(Long id) {
        try {
            Optional<Comment> comment = commentRepository.findById(id);
            if (comment != null) {
                commentRepository.deleteById(id);
                return this.responseService.formulateResponseDto(null, "Comment Deleted Successfully", HttpStatus.OK.value(), true);
            }
        } catch (Exception exception) {
            return this.responseService.formulateResponseDto(null, "Found no Comment with the Id" + id + "", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);

        }
        return this.responseService.formulateResponseDto(null, "n Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
    }
}
