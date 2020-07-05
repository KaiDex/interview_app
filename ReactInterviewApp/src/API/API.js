import * as axios from "axios";
import warning from "react-redux/lib/utils/warning";

const instance = axios.create({
   // withCredentials: true,
    baseURL: `http://localhost:8080/`,
    // headers: {'API-KEY': '110834f4-4de1-441e-9bfb-f3d1fda8381b'}
});

export const questionsAPI = {
    getQuestions() {
        return instance.get(`category/getAll`)
            .then(response => {
                return console.log(response.data);
            })
    },
    addNewQuestion(category, newQuestion, newAnswer) {
        return instance.post(`/...указать доп. путь/`, {category, newQuestion, newAnswer})
    }
};
