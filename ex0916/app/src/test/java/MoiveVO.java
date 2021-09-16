public class MoiveVO {


    //oop
    //1. 멤버 변수 = 필드, 속성 , 특성, 컬럼
    //2. 멤버 함수 = 기능, 행위, 동작, 메소드

    //순서 중요하다다
   private String rank;
   private String rankOldAndNew;
   private String movieNm;
   private String audiAcc;
   private String openDt;
    //1. 생성자
    //2. 게터만 ,,!

    public MoiveVO(String rank, String rankOldAndNew, String movieNm, String audiAcc, String openDt) {
        this.rank = rank;
        this.rankOldAndNew = rankOldAndNew;
        this.movieNm = movieNm;
        this.audiAcc = audiAcc;
        this.openDt = openDt;
    }

    public String getRank() {
        return rank;
    }

    public String getRankOldAndNew() {
        return rankOldAndNew;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public String getAudiAcc() {
        return audiAcc;
    }

    public String getOpenDt() {
        return openDt;
    }
}
