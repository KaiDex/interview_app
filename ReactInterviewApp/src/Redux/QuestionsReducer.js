import React from "react";
import {questionsAPI} from "../API/API";


const GET_QUESTIONS = 'GET_QUESTIONS';
const ADD_NEW_QUESTION = 'ADD_NEW_QUESTION';


let initialReducer = {
    questions: [],
};

const questionsReducer = (state = initialReducer, action) => {
    switch (action.type) {
        case GET_QUESTIONS:
            return {
                ...state,
                questions: [...action.questions]
            }

        default:
            return state;
    }
};


export const getQuestions = (questions) => {
    return {type: GET_QUESTIONS, questions}
};


export const getQuestionsThunkCreator = () => {
    return async (dispatch) => {
        let data = await questionsAPI.getQuestions();
        dispatch(getQuestions(data.items));
    };
}

export const addNewQuestionThunkCreator = (category, newQuestion, newAnswer) => {
    return async (dispatch) => {
        let response = await questionsAPI.addNewQuestion(category, newQuestion, newAnswer);
        if (response.resultCode === 0) {
           alert('Question added')
        }
    }
};


export default questionsReducer;