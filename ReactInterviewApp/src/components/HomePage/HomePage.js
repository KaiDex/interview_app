import React from "react";
import {getQuestionsThunkCreator} from "../../Redux/QuestionsReducer";

const HomePage =(props)=>{

    return (
        <div>
              <button onClick={getQuestionsThunkCreator()}></button>
        </div>


    )
}


export default HomePage;