package com.quiz.petspirit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


public class QuestionOneFragment extends Fragment {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private QuestionViewModel questionViewModel;
    PetName answer;
    TextView next_btn;
    TextView title;
    int tap = 0;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_one, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionViewModel = new ViewModelProvider(requireActivity()).get(QuestionViewModel.class);
        questionViewModel.initialiseQuestions();

        title = view.findViewById(R.id.questionTitle);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        progressBar = view.findViewById(R.id.progressBar);
        next_btn = view.findViewById(R.id.next_btn);


        if (answer != null) {
            questionViewModel.chosenAnswers.remove(0);
            answer = null;
            next_btn.setEnabled(false);
        }

        setUpUI();

        initializeButton();

        clickHandler(button1);
        clickHandler(button2);
        clickHandler(button3);
        clickHandler(button4);

        setObservers();
    }


    public void setUpUI() {
        title.setText(questionViewModel.question.get(0).getTitle());
        button1.setText(questionViewModel.question.get(0).getAnswers()[0].getAnswer());
        button2.setText(questionViewModel.question.get(0).getAnswers()[1].getAnswer());
        button3.setText(questionViewModel.question.get(0).getAnswers()[2].getAnswer());
        button4.setText(questionViewModel.question.get(0).getAnswers()[3].getAnswer());
    }


    private void initializeButton() {
        next_btn.setOnClickListener(
                view12 -> {
                    questionViewModel.chosenAnswers.add(answer);
                    //Navigation.findNavController(view12).navigate(R.id.questionTwoFragment);
                }
        );
    }


    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    private void clickHandler(final Button button) {
        button.setOnClickListener(view -> {
            Answers[] currentAnswers = questionViewModel.question.get(0).getAnswers();
            switch (view.getId()) {
                case R.id.button1:
                    button2.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button3.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button4.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button1.setBackground(getResources().getDrawable(R.drawable.bg_pressed));
                    questionViewModel.getPetName().setValue(currentAnswers[0].getPet());
                    break;
                case R.id.button2:
                    button2.setBackground(getResources().getDrawable(R.drawable.bg_pressed));
                    button1.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button3.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button4.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    questionViewModel.getPetName().setValue(currentAnswers[1].getPet());
                    break;
                case R.id.button3:
                    button3.setBackground(getResources().getDrawable(R.drawable.bg_pressed));
                    button1.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button2.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button4.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    questionViewModel.getPetName().setValue(currentAnswers[2].getPet());
                    break;
                case R.id.button4:
                    button4.setBackground(getResources().getDrawable(R.drawable.bg_pressed));
                    button1.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button2.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    button3.setBackground(getResources().getDrawable(R.drawable.button_bg_transparent));
                    questionViewModel.getPetName().setValue(currentAnswers[3].getPet());
                    break;
            }
        });
    }


    public void setObservers() {
        final Observer<PetName> buttonObserver = new Observer<PetName>() {
            @Override
            public void onChanged(@Nullable final PetName petName) {
                answer = petName;
                next_btn.setEnabled(true);
                tap++;
                if (tap == 1) {
                    progressBar.setProgress(20);
                }
            }
        };

        questionViewModel.getPetName().observe(getViewLifecycleOwner(), buttonObserver);
    }
}
