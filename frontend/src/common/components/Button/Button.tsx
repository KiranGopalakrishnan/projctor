import * as React from 'react';
import styled from 'styled-components';


const getHeight = ({height}: {height: number}) => height;
const getWidth = ({width}: {width: number}) => width;
const getColor = ({color}: {color: string}) => color;

const ButtonControl = styled.button<{color: string; width: number; height: number}>`
    background: ${getColor};
    height: ${getHeight}px;
    width: ${getWidth}px;
    padding: 8px;
    color: #FFF;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    border-radius: 5px;
    border: solid 2px ${getColor};
    boz-sizing: border-box;
    cursor: pointer;

    &:focus{
        outline: none;
    }
`;

interface Props {
    color: string;
    width?: number;
    height?: number;
    children: React.ReactNode;
}

const Button: React.FC<Props> = ({color, width, height, children}: Props) => {
return <ButtonControl type='button' color={color} height={height} width={width} >{children}</ButtonControl>;
};

Button.defaultProps = {
    height: 40,
    width: 300,
};

export {Button};
