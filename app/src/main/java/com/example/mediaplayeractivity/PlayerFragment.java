package com.example.mediaplayeractivity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class PlayerFragment extends Fragment {
    String url;
    static String AR="ar.mp3";
    static String ENG="eng.mp3";
    static String FR="fr.mp3";
    String phrase;

    SimpleExoPlayer sound;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        //TODO (6) : Use getArguments to get position and phrase



        TextView textView =view.findViewById(R.id.phrase);
        Button engButton =view.findViewById(R.id.eng);
        Button arButton =view.findViewById(R.id.ar);
        Button frButton =view.findViewById(R.id.fr);

        textView.setText(phrase);
        engButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(ENG);
            }
        });
        arButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(AR);
            }
        });
        frButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(FR);
            }
        });


        switch (phrasePosition){

            case 0:
                url = "asset:///how_are_you_";
                break;

            case 1: url = "asset:///hello_";
                break;

            case 2: url = "asset:///good_morning_";
                break;

            case 3: url = "asset:///good_night_";
                break;

        }

         return  view;
    }




        public void playSound(String lang){
        Uri uri=Uri.parse(url+lang);
        Log.i("PlayerFragment","Url is :"+url+lang);
        //TODO (7) : Define SimpleExoPlayer:sound ,TrackSelector and LoadControl



        String userAgent= Util.getUserAgent(getContext(),"MediaPlayerApp");
        MediaSource mediaPlayer =new ExtractorMediaSource(uri,new DefaultDataSourceFactory(getContext(),userAgent)
                ,new DefaultExtractorsFactory()
                ,null,null);
        sound.prepare(mediaPlayer);
        sound.setPlayWhenReady(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //TODO (8) : Release  sound

    }
}
