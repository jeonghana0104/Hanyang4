package ac.kr.hanyang.backendEx.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
@Builder
@Getter
public class ResponseDto<T> {

    private HttpStatus statusCode;
    @Builder.Default
    private String resultMsg = "";
    private boolean resultNextPage;
    private Integer resultTotPage;
    private Long resultTotCnt;
    private T resultData;
    private T resultData2;
    @Builder.Default
    private Integer id = 0;

    public ResponseDto(HttpStatus statusCode
            , String resultMsg
            , boolean resultNextPage
            , Integer resultTotPage
            , Long resultTotCnt
            , T resultData
            , Integer id) {
        this.statusCode = statusCode;
        this.resultMsg = resultMsg;
        this.resultNextPage = resultNextPage;
        this.resultTotPage = resultTotPage;
        this.resultTotCnt = resultTotCnt;
        this.id = id;
        this.resultData = resultData;
    }

    public ResponseDto(HttpStatus statusCode
            , String resultMsg
            , boolean resultNextPage
            , Integer resultTotPage
            , Long resultTotCnt
            , T resultData
            , T resultData2
            , Integer id) {
        this.statusCode = statusCode;
        this.resultMsg = resultMsg;
        this.resultNextPage = resultNextPage;
        this.resultTotPage = resultTotPage;
        this.resultTotCnt = resultTotCnt;
        this.id = id;
        this.resultData = resultData;
        this.resultData2 = resultData2;
    }

    public ResponseDto(HttpStatus statusCode
            , String resultMsg
            , boolean resultNextPage
            , Integer resultTotPage
            , Long resultTotCnt
            , T resultData) {
        this.resultMsg = resultMsg;
        this.resultNextPage = resultNextPage;
        this.resultTotPage = resultTotPage;
        this.resultTotCnt = resultTotCnt;
        this.resultData = resultData;
    }

    public static <T> ResponseDto<T> res(final HttpStatus statusCode
            , final String resultMsg
            , final T t) {
        return ResponseDto.<T>builder()
                .resultData(t)
                .statusCode(statusCode)
                .resultMsg(resultMsg)
                .build();
    }

    public static <T> ResponseDto<T> res(final HttpStatus statusCode
            , final String resultMsg
            , final boolean resultNextPage
            , final Integer resultTotPage
            , final Long resultTotCnt
            , final T t) {
        return ResponseDto.<T>builder()
                .resultData(t)
                .statusCode(statusCode)
                .resultMsg(resultMsg)
                .resultNextPage(resultNextPage)
                .resultTotPage(resultTotPage)
                .resultTotCnt(resultTotCnt)
                .build();
    }

    public static <T> ResponseDto<T> res(final HttpStatus statusCode
            , final String resultMsg
            , final boolean resultNextPage
            , final Integer resultTotPage
            , final Long resultTotCnt
            , final T t
            , Integer id
    ) {
        return ResponseDto.<T>builder()
                .id(id)
                .resultData(t)
                .statusCode(statusCode)
                .resultMsg(resultMsg)
                .resultNextPage(resultNextPage)
                .resultTotPage(resultTotPage)
                .resultTotCnt(resultTotCnt)
                .build();
    }

    public static <T> ResponseDto<T> res(final HttpStatus statusCode
            , final String resultMsg
            , final boolean resultNextPage
            , final Integer resultTotPage
            , final Long resultTotCnt
            , final T t
            , final T t2
            , Integer id
    ) {
        return ResponseDto.<T>builder()
                .id(id)
                .resultData(t)
                .resultData(t2)
                .statusCode(statusCode)
                .resultMsg(resultMsg)
                .resultNextPage(resultNextPage)
                .resultTotPage(resultTotPage)
                .resultTotCnt(resultTotCnt)
                .build();
    }

    public static <T> ResponseDto<T> res(final HttpStatus statusCode
            , final String resultMsg
            , final boolean resultNextPage
            , final Integer resultTotPage
            , final T t) {
        return ResponseDto.<T>builder()
                .resultData(t)
                .statusCode(statusCode)
                .resultMsg(resultMsg)
                .resultNextPage(resultNextPage)
                .resultTotPage(resultTotPage)
                .build();
    }

}
