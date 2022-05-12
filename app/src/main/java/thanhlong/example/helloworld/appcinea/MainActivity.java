package thanhlong.example.helloworld.appcinea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewItem;
    private ArrayList<String> listMenu ;
    private NavigationView navigationViewMain;
    private DrawerLayout drawerLayoutMain;
    private Account account;
    private TextView name,code;
    private ImageView avatar, btnInf, btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        navInformationAction();
        navMenuAction();
        menuAction();
        menuLeftAction();
    }

    private void menuLeftAction() {
        listMenu = new ArrayList<String>();
        listMenu.add("Đặt nhanh");
        listMenu.add("Đăng xuất");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listMenu);
        listViewItem.setAdapter(adapter);
    }


    // right Menu
    private void navInformationAction() {
        btnInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayoutMain.openDrawer(GravityCompat.END);
            }
        });
    }


    // left Menu
    private void navMenuAction() {
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayoutMain.openDrawer(GravityCompat.START);

            }
        });
    }



    private void menuAction() {
        account = new Account(R.drawable.ic_menu_camera,"Thành Long", "0966828381");
        name.setText(account.getName());
        code.setText(account.getCodeNumber());
        avatar.setImageResource(account.getAvatar());
    }


    private void mapping(){
        navigationViewMain = (NavigationView) findViewById((R.id.navigation_information));
        drawerLayoutMain = (DrawerLayout) findViewById(R.id.draw_layout_right);
        name = findViewById(R.id.inf_name);
        code = findViewById(R.id.inf_code);
        avatar = findViewById(R.id.inf_avatar);
        btnInf = findViewById(R.id.nav_information);
        btnMenu = findViewById(R.id.nav_menu);
        listViewItem = findViewById(R.id.list_menu);
    }
}