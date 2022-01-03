package com.quiz.petspirit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

public class QuestionThreeFragment extends Fragment {
    ProgressBar progressBar;
    SeekBar seekBar;
    private Answers[] currentAnswers;
    private QuestionViewModel questionViewModel;
    TextView title;
    TextView finish;
    PetName answer;
    int tap;
    TextView back_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionViewModel = new ViewModelProvider(requireActivity()).get(QuestionViewModel.class);
        questionViewModel.initialiseQuestions();

        finish = view.findViewById(R.id.next_btn3);
        back_btn = view.findViewById(R.id.back_btn3);
        progressBar = view.findViewById(R.id.progressBar);
        seekBar = view.findViewById(R.id.seekBar);
        title = view.findViewById(R.id.questionTitle);


        title.setText(questionViewModel.question.get(2).getQuestion());

        if (answer != null) {
            questionViewModel.chosenAnswers.remove(2);
            answer = null;
            finish.setEnabled(false);
        }

        checkSeekBarProgress();

        initializeButtons();

        setObservers();

    }

    private void checkSeekBarProgress() {
        currentAnswers = questionViewModel.question.get(2).getAnswers();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //nothing
                finish.setEnabled(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();

                if (progress < 25) {
                    questionViewModel.getPetName().setValue(currentAnswers[3].getPet());
                } else if (progress < 50) {
                    questionViewModel.getPetName().setValue(currentAnswers[1].getPet());

                } else if (progress < 75) {
                    questionViewModel.getPetName().setValue(currentAnswers[0].getPet());

                } else {
                    questionViewModel.getPetName().setValue(currentAnswers[1].getPet());
                }

            }
        });
    }

    private void initializeButtons() {
        finish.setOnClickListener(
                view1 -> {
                    questionViewModel.chosenAnswers.add(answer);
                    Intent i = new Intent(getActivity(), ResultsActivity.class);
                    i.putParcelableArrayListExtra("results", questionViewModel.chosenAnswers);
                    startActivity(i);
                    ((Activity) getActivity()).overridePendingTransition(0, 0);
                }
        );

        back_btn.setOnClickListener(
                view12 -> {
                    Navigation.findNavController(view12).popBackStack();
                }
        );
    }

    private void setObservers() {
        final Observer<PetName> buttonObserver = new Observer<PetName>() {
            @Override
            public void onChanged(@Nullable final PetName petName) {
                answer = petName;
                tap++;
                if (tap == 1) {
                    progressBar.setProgress(60);
                }
            }
        };

        questionViewModel.getPetName().observe(getViewLifecycleOwner(), buttonObserver);
    }
}
