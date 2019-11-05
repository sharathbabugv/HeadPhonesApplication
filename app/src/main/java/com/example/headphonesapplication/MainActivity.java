package com.example.headphonesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnRecyclerItemClickListener {

    private List<MainModel> mainModelList;
    private int[] imagesList = {R.drawable.red_headphone, R.drawable.black_headphone,
            R.drawable.dark_blue_headphone, R.drawable.yellow_headphone};

    private ImageView imageView;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        relativeLayout = findViewById(R.id.relativeLayout);
        LinearLayout detailsLayout = findViewById(R.id.detailsLayout);
        LinearLayout descLayout = findViewById(R.id.descLayout);
        //Widgets
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mainModelList = new ArrayList<>();

        paletteGenerator();

        for (Integer i : imagesList) {
            MainModel mainModel = new MainModel();
            mainModel.setImages(i);
            mainModelList.add(mainModel);
        }
        MainAdapter adapter = new MainAdapter(mainModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerItemClickListener(this);

        setCustomAnimation(imageView, 2000, R.anim.slide_in_left);
        setCustomAnimation(recyclerView, 3000, R.anim.slide_in_right);
        setCustomAnimation(detailsLayout, 4000, R.anim.slide_in_top);
        setCustomAnimation(descLayout, 5000, R.anim.slide_in_down);
    }

    private void setCustomAnimation(View view, long ms, int anim) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), anim);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(ms);
        view.startAnimation(animation);
    }

    public Palette createPaletteSync(Bitmap bitmap) {
        return Palette.from(bitmap).generate();
    }

    public void paletteGenerator() {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        Palette palette = createPaletteSync(bitmap);
        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
        Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
        if (vibrantSwatch != null) {
            int bgColor = vibrantSwatch.getRgb();
            relativeLayout.setBackgroundColor(bgColor);
            getWindow().setStatusBarColor(bgColor);
        } else if (darkMutedSwatch != null) {
            int bgColor = darkMutedSwatch.getRgb();
            relativeLayout.setBackgroundColor(bgColor);
            getWindow().setStatusBarColor(bgColor);
        } else {
            relativeLayout.setBackgroundColor(Color.BLACK);
            getWindow().setStatusBarColor(Color.BLACK);
        }
    }

    @Override
    public void onClick(int pos) {
        //image will be changed when recycler item is clicked.
        imageView.setImageResource(mainModelList.get(pos).getImages());
        //color will be picked from selected image from recycler view item.
        paletteGenerator();
    }
}
