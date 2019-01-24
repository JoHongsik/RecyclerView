package com.example.myapplication2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Dictionary> mList;    // Dictionary에 대한 데이터를 담을 리스트

    public class CustomViewHolder extends RecyclerView.ViewHolder { // Viewholder를 부모로 하는 자식 클래스
        protected TextView id;  // 자료형이 textview인 id를 가지고 있음
        protected TextView english; // 자료형이 textview인 eglish를 가지고 있음
        protected TextView korean;  //자료형이 textview인 korean을 가지고 있음
        public final View mview;    // 자료형이 View인 mview를 가지고 있어

        public CustomViewHolder(View view) {    // viewholder의 생성자
            super(view);
            mview = view;
            this.id = (TextView) view.findViewById(R.id.textview_recyclerview_id);  //id의 textview를 갖게됨
            this.english = (TextView) view.findViewById(R.id.textview_recyclerview_english); //english의 textview를 갖게됨
            this.korean = (TextView) view.findViewById(R.id.textview_recyclerview_korean);  // korean의 textview를 갖게됨
        }
    }


    public CustomAdapter(ArrayList<Dictionary> list) {  // customadapter의 생성자
        this.mList = list;  //list정보를 저장
    }




    // RecyclerView에 새로운 데이터를 보여주기 위해 필요한 ViewHolder를 생성해야 할 때 호출됩니다.
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
}



    // Adapter의 특정 위치(position)에 있는 데이터를 보여줘야 할때 호출됩니다.
    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder viewholder, final int position) {

        viewholder.id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.english.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.korean.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewholder.id.setGravity(Gravity.CENTER);
        viewholder.english.setGravity(Gravity.CENTER);
        viewholder.korean.setGravity(Gravity.CENTER);

        viewholder.id.setText(mList.get(position).getId());
        viewholder.english.setText(mList.get(position).getEnglish());
        viewholder.korean.setText(mList.get(position).getKorean());

        viewholder.mview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context context = v.getContext();
                Toast.makeText(context,viewholder.english.getText(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }


}

