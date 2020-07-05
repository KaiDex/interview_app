import React from 'react';
import './App.css';
import Header from "./components/Header/Header";
import {Route, Switch, Redirect, withRouter} from "react-router-dom";
import HomePage from "./components/HomePage/HomePage";
import AddNewQuestion from "./components/AddNewQuestion/AddNewQuestion";
import Nav from "./components/Nav/Nav";
import ChooseTheme from "./components/ChooseTheme/ChooseTheme";
import GetRandomQuestion from "./components/RandomQuestion/GetRandomQuestion";

const App=(props)=> {
  return (
      <div className="app-wrapper">
          <header className="header">
              <Header/>
          </header>
          <nav className='nav'>
              <div>
                  <Nav/>
              </div>
          </nav>
          <div className='mainContent'>
                  <Switch>
                      <Route path='/home' component={HomePage} />
                      <Route path='/ThemeSelectPage' component={ChooseTheme} />
                      <Route path='/RandomQuestion' component={GetRandomQuestion} />
                      <Route path='/addNewQuestion' component={AddNewQuestion} />
                      <Redirect from='/' to='/home'/>
                  </Switch>
          </div>
          <footer className='footer'></footer>
      </div>

    );



}
export default App;
