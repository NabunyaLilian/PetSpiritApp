package com.quiz.petspirit;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


public class QuestionTwoFragment extends Fragment {
    private CheckBox checkBox;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private QuestionViewModel questionViewModel;
    private ProgressBar progressBar;
    private Answers[] currentAnswers;
    TextView title;
    PetName answer;
    TextView next_btn;
    int tap;
    TextView back_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionViewModel = new ViewModelProvider(requireActivity()).get(QuestionViewModel.class);
        questionViewModel.initialiseQuestions();

        next_btn = view.findViewById(R.id.next_btn2);
        back_btn = view.findViewById(R.id.back_btn2);
        title = view.findViewById(R.id.questionTitle);
        checkBox = view.findViewById(R.id.checkBox);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        progressBar = view.findViewById(R.id.progressBar);

        if (answer != null) {
            questionViewModel.chosenAnswers.remove(1);
            answer = null;
            next_btn.setEnabled(false);
        }


        setUpUI();

        initializeCheckboxes();

        initializeButtons();

        setObservers();
    }


    private void setUpUI() {
        title.setText(questionViewModel.question.get(1).getTitle());
        checkBox.setText(questionViewModel.question.get(1).getAnswers()[0].getAnswer());
        checkBox2.setText(questionViewModel.question.get(1).getAnswers()[1].getAnswer());
        checkBox3.setText(questionViewModel.question.get(1).getAnswers()[2].getAnswer());
        checkBox4.setText(questionViewModel.question.get(1).getAnswers()[3].getAnswer());
    }


    private void initializeCheckboxes() {
        currentAnswers = questionViewModel.question.get(1).getAnswers();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    questionViewModel.getPetName().setValue(currentAnswers[0].getPet());
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    questionViewModel.getPetName().setValue(currentAnswers[1].getPet());
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    questionViewModel.getPetName().setValue(currentAnswers[2].getPet());
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    questionViewModel.getPetName().setValue(currentAnswers[3].getPet());
                }
            }
        });
    }


    private void initializeButtons() {
        next_btn.setOnClickListener(
                view1 -> {
                    questionViewModel.chosenAnswers.add(answer);
                    //Navigation.findNavController(view1).navigate(R.id.quizFragment);
                }
        );

        back_btn.setOnClickListener(
                view12 -> {
                    //Navigation.findNavController(view12).popBackStack();
                }
        );
    }


    private void setObservers() {
        final Observer<PetName> buttonObserver = new Observer<PetName>() {
            @Override
            public void onChanged(@Nullable final PetName petName) {
                answer = petName;
                next_btn.setEnabled(true);
                tap++;
                if (tap == 1) {
                    progressBar.setProgress(40);
                }
            }
        };

        questionViewModel.getPetName().observe(getViewLifecycleOwner(), buttonObserver);
    }

}
