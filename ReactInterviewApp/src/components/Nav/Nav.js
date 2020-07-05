import React from 'react';
import classes from './../Nav/Nav.module.css';
import {NavLink} from "react-router-dom";

const Nav = (props) => {
    return <nav className={classes.nav}>
        <div className={classes.item}>
            <NavLink to='/ThemeSelectPage' activeClassName={classes.active}>Choose Theme</NavLink>
        </div>
        <div className={`${classes.item} {/*${classes.active}*/}`}>
            <NavLink to='/RandomQuestion' activeClassName={classes.active}>Get Random Question</NavLink>
        </div>
        <div className={classes.item}>
            <NavLink to='/addNewQuestion' activeClassName={classes.active}>Add New Question</NavLink>
        </div>
    </nav>
}

export default Nav;