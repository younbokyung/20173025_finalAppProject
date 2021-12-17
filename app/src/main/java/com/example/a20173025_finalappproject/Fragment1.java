package com.example.a20173025_finalappproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Fragment1 extends Fragment {
    EditText editText;
    TextView textView;
    DatePickerDialog.OnDateSetListener callbackMethon;
    int selectedMovieMenu;
    Context context;


    static RequestQueue requestQueue;

    RecyclerView recyclerView;
    MovieAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        editText = view.findViewById(R.id.xeditText);
        textView = view.findViewById(R.id.textView);

        this.InitalLizelListenner();

        Button button = view.findViewById(R.id.xbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
                //Intent intent = new Intent(getActivity(), movieinfo.class);
                //startActivity(intent);
            }
        });

        Button datebutton = view.findViewById(R.id.dateBtn);
        datebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataProcess(v);
            }
        });

        Button moviebutton= (Button) view.findViewById(R.id.movieBtn);
        moviebutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                showDialog(AppConstants.DIALOG_RADIO);
           }
        });

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getContext());
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager
                (getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        return view;

    }


    public void showDialog(int id) {
        AlertDialog.Builder builder2 = null;


        switch(id) {

            case AppConstants.DIALOG_RADIO:
                builder2 = new AlertDialog.Builder(context);

                builder2.setTitle("예매할 영화관을 선택해주세요.");
                builder2.setSingleChoiceItems(R.array.array_movie, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        selectedMovieMenu = whichButton;
                    }
                });
                builder2.setPositiveButton("선택", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(selectedMovieMenu == 0 ) {
                            showMoviecgvActivity();
                        } else if(selectedMovieMenu == 1) {
                            showMoviemegaActivity();
                        } else if(selectedMovieMenu == 2) {
                            showMovielotteActivity();
                        }
                    }
                });
                builder2.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                break;

            default:
                break;
        }

        AlertDialog dialog = builder2.create();
        dialog.show();
    }

    public void showMoviecgvActivity() {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cgv.co.kr/"));
        startActivity(intent);
    }

    public void showMoviemegaActivity() {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.megabox.co.kr/"));
        startActivity(intent);
    }

    public void showMovielotteActivity() {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lottecinema.co.kr/NLCHS"));
        startActivity(intent);
    }



    public void InitalLizelListenner() {
        callbackMethon = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String year1 = String.valueOf(year);
                String month1 = String.valueOf(month + 1);
                String dayOfMonth1 = String.valueOf(dayOfMonth);


                String month2 = null;
                String dayOfMonth2 = null;

                if (month1.length() < 2) {
                    month2 = '0' + month1;
                } else {
                     month2 = month1;
                }

                if (dayOfMonth1.length() < 2) {
                    dayOfMonth2 = '0' + dayOfMonth1;
                } else {
                    dayOfMonth2 = dayOfMonth1;
                }

                    String date = year1 + month2 + dayOfMonth2;
                    editText.setText(date);


           }

        };

    }

    public void dataProcess(View v) {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), callbackMethon, 2021, 11, 10);
        dialog.show();
    }

    public void makeRequest() {
        String day = editText.getText().toString();

        String url = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=4ea41466d4d3a46f5781b79523c2f87b&targetDt=" + day;

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 -> " + response);
                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 -> " + error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청 보냄.");
        Toast.makeText(getContext(), day + " 영화 정보", Toast.LENGTH_LONG).show();
    }

    public void println(String data) {
        Log.d("Fragment", data);
    }
    public  void processResponse(String response)
    {
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response, MovieList.class);
        println("영화 정보의 수 : " + movieList.boxOfficeResult.dailyBoxOfficeList.size());

        for(int i=0; i< movieList.boxOfficeResult.dailyBoxOfficeList.size();i++){
            Movie movie = movieList.boxOfficeResult.dailyBoxOfficeList.get(i);
            adapter.addItem(movie);
        }
        adapter.notifyDataSetChanged();
    }

}