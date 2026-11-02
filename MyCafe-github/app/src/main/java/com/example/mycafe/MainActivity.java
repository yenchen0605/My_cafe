package com.example.mycafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycafe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                // The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"C109118111@nkust.edu.tw"}); // 收件人
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
                // You can also attach multiple items by passing an ArrayList of Uris
                startActivity(emailIntent);

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
                Toast.makeText(view.getContext(), "Send Email !", Toast.LENGTH_LONG).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_cart, R.id.nav_value)
                .setOpenableLayout(drawer)
                .build();
        BottomNavigationView bottomNav = findViewById(R.id.botton_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController );
        NavigationUI.setupWithNavController(bottomNav, navController);


    }

    public void bottonClick(View view) {
        switch (view.getId()) {
            case R.id.bt_enter:
                OK();
                break;
            case R.id.bt_value:
                add();
                break;
            case R.id.bt_save:
                Toast.makeText(getApplicationContext(), "Success!!", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_over:
                Toast.makeText(getApplicationContext(), "結帳中!!", Toast.LENGTH_LONG).show();
                break;
        }
    }
    public void OK() {
        DialogFragment newFragment = new EnterFragment();
        newFragment.show(getSupportFragmentManager(), "OK");
    }
    public void add() {
        DialogFragment newFragment = new ValueDialogFragment();
        newFragment.show(getSupportFragmentManager(), "Add");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Uri webpage = Uri.parse("https://www.google.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                Toast.makeText(this, "Search !!!", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_map:
                // Map point based on address
                Uri location = Uri.parse("geo:0,0?q=811高雄市楠梓區土庫二路190號");
                // Or map point based on latitude/longitude
                // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
                Toast.makeText(this, "Here !!!", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}