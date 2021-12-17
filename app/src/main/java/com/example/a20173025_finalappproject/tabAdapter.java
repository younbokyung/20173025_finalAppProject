package com.example.a20173025_finalappproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class tabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        ArrayList<tab> tabsArray;




        public class myViewHolder extends RecyclerView.ViewHolder {

                ImageView icon ;


                TextView tab_name,  tab_role, tab_diff;


                public myViewHolder(@NonNull View itemView) {
                        super(itemView);
                        tab_name = itemView.findViewById(R.id.tab_name1);
                        tab_role = itemView.findViewById(R.id.tab_role1);
                        tab_diff = itemView.findViewById(R.id.tab_diff1);
                        icon = itemView.findViewById(R.id.imageIcon1) ;
                }
        }

        // 리사이클러뷰 어댑터 생성자 설정
        tabAdapter(ArrayList<tab> tabsArray) {
                // 출력할 객체들을 담고있는 ArrayList를 parameter로 받음
                this.tabsArray = tabsArray;
        }

        @NonNull
        @Override // RecyclerView의 item(row)를 표시하는데 사용되는 rv_profile.row.xml을 가져오는 역할
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viweType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item, parent, false);
                return new myViewHolder(v);
        }

        @Override // RecyclerView의 item(row)에 보여질 TextView를 설정
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                myViewHolder myViewHolder = (tabAdapter.myViewHolder) holder;
                myViewHolder.tab_name.setText(tabsArray.get(position).getName());
                myViewHolder.tab_role.setText(tabsArray.get(position).getTabrole());
                myViewHolder.tab_diff.setText(tabsArray.get(position).getTabdiff());
                myViewHolder.icon.setImageDrawable(tabsArray.get(position).getIcon()) ;


        }


        @Override
        public int getItemCount() {
                return tabsArray.size(); // ArrayList에 저장된 객체의 개수를 리턴
        }

}