package com.example.a008052146utsga;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a008052146utsga.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gantiFragment(new LokasiSaatIniFragment());
        binding.judul.setText(getString(R.string.judul1));
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.lsi:
                    gantiFragment(new LokasiSaatIniFragment());
                    binding.judul.setText(getString(R.string.judul1));
                    break;
                case R.id.pl:
                    gantiFragment(new PencarianLokasiFragment());
                    binding.judul.setText(getString(R.string.judul2));
                    break;
                case R.id.tls:
                    gantiFragment(new TitikLokasiSekarangFragment());
                    binding.judul.setText(getString(R.string.judul3));
                    break;
            }

            return true;
        });
    }

    private void gantiFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}