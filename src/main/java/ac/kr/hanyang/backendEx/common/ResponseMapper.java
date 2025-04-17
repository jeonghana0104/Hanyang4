package ac.kr.hanyang.backendEx.common;

import ac.kr.hanyang.backendEx.dto.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ResponseMapper {

  private final ObjectMapper objectMapper;

  public void defaultJsonResponse(
      final HttpServletResponse response,
      final HttpStatus httpStatus,
      final String message,
      final Object data
  ) throws IOException {
    String responseBody = objectMapper.writeValueAsString(ResponseDto.res(httpStatus, message, data));
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setStatus(httpStatus.value());
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(responseBody);
  }
}
