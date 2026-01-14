const { animate } = require('animejs');

document.addEventListener('DOMContentLoaded', () => {
    const [$button] = utils.$('button');
    const [$p] = utils.$('p');

    const split = splitText('p', {
        words: { wrap: 'clip' },
        debug: true,
    });

    split.addEffect((self) => animate(self.words, {
        y: ['100%', '0%'],
        duration: 1250,
        ease: 'out(3)',
        delay: stagger(100),
        loop: true,
        alternate: true,
    }));

    const revertSplit = () => {
        split.revert();
        $button.setAttribute('disabled', 'true');
    }

    $button.addEventListener('click', revertSplit);
})