package com.jayseeofficial.playingwithdesign;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @InjectView(R.id.nav_drawer)
    DrawerLayout navigationDrawer;

    @InjectView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        navigationDrawer.openDrawer(GravityCompat.START);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        boolean actionDone = false;
        if (id == R.id.action_floating_action_button) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, FloatingActionButtonFragment.getInstance())
                    .commit();
            actionDone = true;
        } else if (id == R.id.action_snackbar) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, SnackbarFragment.getInstance())
                    .commit();
            actionDone = true;
        } else if (id == R.id.action_text_input_layout) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, TextInputLayoutFragment.getInstance())
                    .commit();
            actionDone = true;
        } else {
            Toast.makeText(this, "Unimplemented:\n" + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (actionDone) navigationDrawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
