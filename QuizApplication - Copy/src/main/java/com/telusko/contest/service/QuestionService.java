package com.telusko.contest.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.contest.entity.Questions;
import com.telusko.contest.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Questions createQuestion(Questions question) {
       
        return questionRepository.save(question);
    }

    public Questions getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
    }

    public Questions updateQuestion(Long id, Questions updatedQuestion) {
        Questions question = getQuestionById(id);
        
        question.setQuestionText(updatedQuestion.getQuestionText());
        question.setOption1(updatedQuestion.getOption1());
        question.setOption2(updatedQuestion.getOption2());
        question.setOption3(updatedQuestion.getOption3());
        question.setOption4(updatedQuestion.getOption4());
        question.setCorrectOption(updatedQuestion.getCorrectOption());
        question.setTechnology(updatedQuestion.getTechnology());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        Questions question = getQuestionById(id);
        
        questionRepository.delete(question);
    }

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }
}
