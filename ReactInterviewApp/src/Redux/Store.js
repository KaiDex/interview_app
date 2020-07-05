import {applyMiddleware, combineReducers, compose, createStore} from "redux";
import thunkMiddleWare from "redux-thunk";
import { reducer as formReducer } from 'redux-form'
import questionsReducer from "./QuestionsReducer";


let reducers = combineReducers({
    form: formReducer,
    questions: questionsReducer
});

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const store = createStore(reducers, composeEnhancers(
    applyMiddleware(thunkMiddleWare)
));


window.store = store;

export default store