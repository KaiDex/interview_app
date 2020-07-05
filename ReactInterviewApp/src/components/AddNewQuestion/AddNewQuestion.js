import React from "react";
import {Field, reduxForm} from 'redux-form';
import {connect} from "react-redux";
import {addNewQuestionThunkCreator} from "../../Redux/QuestionsReducer";


let AddNewQuestionForm = (props) => {
    return (
        <form onSubmit={props.handleSubmit}>
            <div><h3>Add new question</h3></div>
            <div>
                <Field component='input' type='text' placeholder="Category" name="category"/>
            </div>
            <div>
                <Field component='textarea' type='text' placeholder="Enter new question"  name="question" />
            </div>
            <div>
                <Field component='textarea' type='text' placeholder="Enter your answer"  name="answer" />
            </div>
            <div>
                <button type="submit">submit</button>
            </div>
        </form>
    )
};

const ReduxQuestionForm = reduxForm({form: 'addNewQuestionForm'})(AddNewQuestionForm);

const AddNewQuestion =(props)=>{
    //const onSubmit = (data) => console.log(data);
    const onSubmit = (data) => props.addNewQuestionThunkCreator(data.category, data.question, data.answer);
    return <ReduxQuestionForm onSubmit={onSubmit}/>;
}

const mapStateToProps = (state) => {
    return {
        questions: state.questions.questions,
    }
};

export default connect(mapStateToProps, {addNewQuestionThunkCreator})(AddNewQuestion);
