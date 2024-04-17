package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment addCommentToCourse(Long courseId, Comment comment);

    List<Comment> getCommentsByCourseId(Long courseId);
}
