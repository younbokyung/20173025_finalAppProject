package com.example.a20173025_finalappproject;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment4 extends Fragment {


    ArrayList<tab> tabsArray = new ArrayList<>();




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);
        super.onCreate(savedInstanceState);

        RecyclerView tablist = view.findViewById(R.id.tabrecyclerview);
        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        //ImageView imageview = view.findViewById(R.id.imageIcon1);

        Button button = (Button) view.findViewById(R.id.backBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        tabAdapter myAdapter = new tabAdapter(tabsArray);
        tablist.setLayoutManager(myLayoutManager); // 생성한 myLayoutManager 객체를 rv_profile 리사이클러뷰의 레이아웃매니져로 설정
        tablist.setAdapter(myAdapter);

        tab testData1 = new tab();
        testData1.setName("영화 순위 탭");
        testData1.setTabrole("일일 박스오피스 순위를 10위까지 리사이클러뷰 형태로 받아볼 수 있으며, 추가로 영화 예매 사이트로 바로 이동할 수 있음.");
        testData1.setTabdiff("※ 기존 과제와 차이점 : 요청하는 주소를 사용자가 사용하기 편리하도록 숫자만 입력할 수 있도록 수정. 리사이클러뷰 형태에 들어가는 항목 추가. 캘린더로 날짜 입력이 가능하도록 함. 월과 일이 한 글자인 경우 앞에 0을 붙이도록 함. 추가로 AlertDialog를 활용하여 영화 예매 사이트를 선택하고 Intent로 바로 예매 사이트로 이동할 수 있도록 함.");
        testData1.setIcon(getActivity().getDrawable(R.drawable.movie));
        // myAdapter의 생성자로 받는 profileDataArray에 객체를 추가하는 방법 => 해당 객체가 row(item)으로 출력됨
        tabsArray.add(testData1);

        tab testData2 = new tab();
        testData2.setName("영화 검색 탭");
        testData2.setTabrole("네이버 검색 api를 이용하여 사용자가 영화를 직접 검색하여 영화 이름, 감독, 출연배우, 평점까지 볼 수 있도록 함. 또한 클릭하면 네이버 검색으로 바로 이동되어 해당 영화 검색 결과가 보여짐.");
        testData2.setTabdiff("※ 기존 과제와 차이점 : 영화진흥위원회 api를 이용하여 일별 박스오피스 순위를 받아본 과제를 응용하여 네이버 api를 이용해 값을 출력해 봄. ");
        testData2.setIcon(getActivity().getDrawable(R.drawable.searchb));
        // myAdapter의 생성자로 받는 profileDataArray에 객체를 추가하는 방법 => 해당 객체가 row(item)으로 출력됨
        tabsArray.add(testData2);

        tab testData3 = new tab();
        testData3.setName("후기 작성 탭");
        testData3.setTabrole("사용자들이 영화 본 후기와 별점, 이미지를 등록할 수 있도록 함.");
        testData3.setTabdiff("※ 기존 과제와 차이점 : 이미지를 클릭하면 카메라로 연결되어 사진을 찍어 찍은 사진을 받아 이미지뷰에 보이도록 함. 이전에 과제로 제출 했던 글자수 표시하기를 응용하여 100자를 입력할 수 있게 하였고, 스크롤 뷰로 쉽게 위로 이동할 수 있도록 함.");
        testData3.setIcon(getActivity().getDrawable(R.drawable.pen));
        tabsArray.add(testData3);




        tab testData4 = new tab();
        testData4.setName("정보 탭");
        testData4.setTabrole("이 프로젝트의 간단한 설명을 남김.");
        testData4.setTabdiff("※ 기존 과제와 차이점 : 영화 리싸이클러뷰를 응용하여 탭 설명을 구성해 봄. 리싸이클러뷰를 가로로 변경하여 가로로 넘기는 형식으로 응용하여 변환함. 또한, 버튼으로 로그인 화면으로 돌아가는 것을 응용함.");
        testData4.setIcon(getActivity().getDrawable(R.drawable.info));
        tabsArray.add(testData4);


        myAdapter.notifyDataSetChanged();
        return view;
    }

    // 객체를 생성 및 ArrayList에 추가하는 메소드
    public void makeNewDataObject(String name, String role, String diff, Drawable Icon) {
        // ArrayList에 추가할 rv_profile_data 객체를 생성한 뒤,
        tab newDataObject = new tab();

        // 생성자로 받은 parameter들을 rv_profile_data 클래스 set 메소드를 이용하여 이름, 나이, 연락처, 좋아하는 것을 설정해줍니다.
        newDataObject.setName(name);
        newDataObject.setTabrole(role);
        newDataObject.setTabdiff(diff);
        newDataObject.setIcon(Icon);

        // 만든 데이터 객체를 ArrayList에 추가합니다. 추가된 데이터는 하나의 item(row)로 출력됩니다.
        tabsArray.add(newDataObject);
    }




}