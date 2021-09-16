package com.jkh.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    Context context; //현재 페이지 정보
    int layout;  //item 디자인 템플릿
    List<MovieVO> data;   //item 클래스

    LayoutInflater inflater ;  //xml파일은 view객체로 변환시키는 역할  // 생성자가 만들어질때 부여할것이다 .

    public MovieAdapter(Context context, int layout, List<MovieVO> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size(); //아이템 개수
    }

    @Override
    public Object getItem(int i) {
        return data.get(i); //몇번째 아이템 ?
    }

    @Override
    public long getItemId(int i) {
        return i;  //아이템 인덱스
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

            if(view==null){//만약 뷰가 없는 경우에 뷰를 만들어줄래
                view = inflater.inflate(layout,null); //레이아웃을 뷰객체로
                
            }
            
            //5개 아이디 초기화
        TextView tv_rank = view.findViewById(R.id.tv_rank);
        TextView tv_rankOldAndNew = view.findViewById(R.id.tv_rankOldAndNew);
        TextView tv_movieNm = view.findViewById(R.id.tv_movieNm);
        TextView tv_audiAcc = view.findViewById(R.id.tv_audiAcc);
        TextView tv_openDt = view.findViewById(R.id.tv_openDt);

        tv_rank.setText(data.get(i).getRank());
        tv_rankOldAndNew.setText(data.get(i).getRankOldAndNew());
        tv_movieNm.setText(data.get(i).getMovieNm());
        tv_audiAcc.setText(data.get(i).getAudiAcc());
        tv_openDt.setText(data.get(i).getOpenDt());

        
        return view;//뷰객체가 리턴
    }
    //무비어댑터 생성
}
