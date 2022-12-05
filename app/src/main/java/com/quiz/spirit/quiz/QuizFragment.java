package com.quiz.spirit.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.quiz.spirit.R;
import com.quiz.spirit.quiz.models.Answers;
import com.quiz.spirit.quiz.models.PetName;
import com.quiz.spirit.quiz.viewmodels.QuizViewModel;


public class QuizFragment extends Fragment {
    private QuizViewModel questionViewModel;
    int pos = 0;
    RadioGroup radioGroup;
    TextView title;
    PetName answer;
    Button next_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioGroup = view.findViewById(R.id.radio_grp);
        title = view.findViewById(R.id.questionTitle);
        next_btn = view.findViewById(R.id.next_btn);

        questionViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);
        questionViewModel.initialiseQuestions();

        setUpUI();
        setObservers();
        onClickBtn();
    }

    public void setUpUI() {
        //update UI with new questions
        title.setText(questionViewModel.question.get(pos).getTitle());
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            ((RadioButton) radioGroup.getChildAt(i)).setText(questionViewModel.question.get(pos).getAnswers()[i].getAnswer());
        }
        onRadioButtonClick();
        pos++;
    }

    public void onClickBtn(){
        //on click next button
        next_btn.setOnClickListener(view1 -> {
            if (pos < 7) {
                questionViewModel.chosenAnswers.add(answer);
                radioGroup.clearCheck();

                try {
                    Thread.sleep(500);
                    setUpUI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                Intent i = new Intent(getActivity(), ResultsActivity.class);
                i.putParcelableArrayListExtra("results", questionViewModel.chosenAnswers);
                startActivity(i);
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClick() {
        // Is the button now checked?
        Answers[] currentAnswers = questionViewModel.question.get(pos).getAnswers();
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_btn1:
                    questionViewModel.getPetName().setValue(currentAnswers[0].getPet());
                    break;
                case R.id.radio_btn2:
                    questionViewModel.getPetName().setValue(currentAnswers[1].getPet());
                    break;
                case R.id.radio_btn3:
                    questionViewModel.getPetName().setValue(currentAnswers[2].getPet());
                    break;
                case R.id.radio_btn4:
                    questionViewModel.getPetName().setValue(currentAnswers[3].getPet());
                    break;
                case R.id.radio_btn5:
                    questionViewModel.getPetName().setValue(currentAnswers[4].getPet());
                    break;

            }
        });
    }

    public void setObservers() {
        final Observer<PetName> buttonObserver = petName -> answer = petName;

        questionViewModel.getPetName().observe(getViewLifecycleOwner(), buttonObserver);
    }

}
