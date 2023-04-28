package pw.ersms.courses.course;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Object getCourse(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("success", true);
        resp.put("message", "Successful fetching data");

        return resp;
    }
}
