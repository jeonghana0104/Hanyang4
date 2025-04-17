package ac.kr.hanyang.backendEx.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class RequestBodyDataDto {

    private String logicOperator;
    private List<SchItemsDto> items; //사용자 선택 검색

    private String actDesc;
    private List<ActItemsDto> ActItems; //처리

    private String schField;
    private String schVal;
    private String schDate;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SchItemsDto {
        private String field;
        private String operator;
        private String value;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActItemsDto {
        private Integer id;
        private LocalDate dt;
        private String inputData;
        private Integer inputCnt;
    }
//
//
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class ActItemsDto {
//        private String field;
//        private String operator;
//        private String value;
//    }
}
