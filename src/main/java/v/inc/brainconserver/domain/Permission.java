package v.inc.brainconserver.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    MENTOR_READ("mentor:read"),
    MENTOR_UPDATE("mentor:update"),
    MENTOR_CREATE("mentor:create"),
    MENTOR_DELETE("mentor:delete"),
    STUDENT_READ("student:read"),
    STUDENT_UPDATE("student:update"),
    STUDENT_CREATE("student:create"),
    STUDENT_DELETE("student:delete")

    ;

    @Getter
    private final String permission;
}
