package ptit.nttrung.tranningfragment.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import ptit.nttrung.tranningfragment.R;
import ptit.nttrung.tranningfragment.base.BaseDrawerActivity;
import ptit.nttrung.tranningfragment.callback.OnActivitySendToFragment;
import ptit.nttrung.tranningfragment.callback.OnListViewItemClickListener;
import ptit.nttrung.tranningfragment.fragment.OneFragment;
import ptit.nttrung.tranningfragment.fragment.TwoFragment;


public class MainActivity extends BaseDrawerActivity implements OnListViewItemClickListener {

    @BindView(R.id.btnCreate)
    FloatingActionButton fabCreate;
    @BindView(R.id.content)
    CoordinatorLayout clContent;

    OneFragment oneFragment;
    TwoFragment twoFragment;

    private OnActivitySendToFragment onActivitySendToFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneFragment = (OneFragment) this.getSupportFragmentManager()
                .findFragmentById(R.id.fragment_one);

        if (oneFragment == null) {
            oneFragment = OneFragment.newInstance();

            FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_one, oneFragment, "Fragment One");
            transaction.commit();
        }

    }

    @Override
    public void onItemClick(int position) {
        int color = OneFragment.COLOURS[position];

        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.hide(oneFragment);

        twoFragment = (TwoFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.fragment_two);

        if (twoFragment == null) {
            twoFragment = TwoFragment.newInstance(color);

            transaction.replace(R.id.fragment_two, twoFragment, "Fragment two");
            onActivitySendToFragment = (TwoFragment) twoFragment;

            transaction.commit();
        }

        onActivitySendToFragment.onSend(color);
    }

    @Override
    public void setNavigationItemSelected() {
        final DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        NavigationView vNavigation = (NavigationView)findViewById(R.id.vNavigation);

        vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.menu_feed:
                        drawerLayout.closeDrawer(Gravity.LEFT,true);
                        break;
                    case R.id.menu_settings:
                        Toast.makeText(MainActivity.this, "Main", Toast.LENGTH_SHORT).show();
                        break;

                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                return true;
            }
        });
    }
}
