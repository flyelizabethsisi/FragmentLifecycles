package org.pursuit.fragmentlifecycles;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static final String FRAGMENT_INT_KEY = "Choice_key";
    public static final String FRAGMENT_STRING_KEY = "String_key";
    private FragmentInterface fragmentInterface;


    public static FirstFragment newInstance(int choice, String string) {
        FirstFragment fragment = new FirstFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(FRAGMENT_INT_KEY, choice);
        arguments.putString(FRAGMENT_STRING_KEY, string);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(FRAGMENT_INT_KEY)
        && getArguments().containsKey(FRAGMENT_STRING_KEY)) {
            int choice = getArguments().getInt(FRAGMENT_INT_KEY);
            String stringgg = getArguments().getString(FRAGMENT_STRING_KEY);
            Toast.makeText(getContext(), stringgg + choice, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
