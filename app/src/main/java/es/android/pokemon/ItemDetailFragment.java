package es.android.pokemon;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import es.android.pokemon.placeholder.PlaceholderContent;
import es.android.pokemon.databinding.FragmentItemDetailBinding;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListFragment}
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    public static final int ARG_ITEM_ID = 0;
    public static final String ARG_ITEM_NAME = "item_name";
    public static final String ARG_DESCRIPTION = "item_description";
    private Integer mItemId;
    private String mItemName;
    private String mItemDescrption;
    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mTextView;
    private FragmentItemDetailBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(String.valueOf(ARG_ITEM_ID))) {
            mItemId = getArguments().getInt(String.valueOf(ARG_ITEM_ID));
            mItemName = getArguments().getString(ARG_ITEM_NAME);
            mItemDescrption = getArguments().getString(ARG_DESCRIPTION);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentItemDetailBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        mToolbarLayout = rootView.findViewById(R.id.toolbar_layout);
        mTextView = binding.itemDetail;
        updateContent();
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void updateContent() {
        if (mItemId != null) {
            mTextView.setText(mItemDescrption);
            if (mToolbarLayout != null) {
                mToolbarLayout.setTitle(mItemName);
            }
            ImageView itemImage = binding.itemImage;
            String pokemonImageUrl =
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + mItemId + ".png";
            Glide.with(this)
                    .load(pokemonImageUrl)
                    .into(itemImage);
        }
    }
}