/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.states;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Kyle
 */
public class StateManager
{

    private State state;
    private HashMap<State, BasicState> map;
    private BasicState currentState = null;

    public StateManager(State state, GameContainer gc, HashMap<State, BasicState> map) throws SlickException
    {
        this.state = state;
        this.map = map;
        this.currentState = map.get(this.state);
    }

    /**
     * Initializes all states.
     * @param gc
     * @throws SlickException 
     */
    public void initAll(GameContainer gc) throws SlickException
    {
        Iterator<BasicState> itr = map.values().iterator();
        while (itr.hasNext())
        {
            itr.next().init(gc);
        }
    }
    
    /**
     * Updates the current state.
     * @param gc
     * @param deltaTime
     * @throws SlickException 
     */
    public void updateCurrent(GameContainer gc, int deltaTime) throws SlickException
    {
        this.currentState.update(gc, deltaTime);
    }
    
    /**
     * Renders the current state.
     * @param gc
     * @param g
     * @throws SlickException 
     */
    public void renderCurrent(GameContainer gc, Graphics g) throws SlickException
    {
        this.currentState.render(gc, g);
    }

    /**
     * Sets the state of the game.
     *
     * @param state
     */
    public void setState(State state)
    {
        this.state = state;
        this.currentState = map.get(this.state);
    }

    /**
     * Gets the state of the game.
     *
     * @return
     */
    public State getState()
    {
        return state;
    }

}
