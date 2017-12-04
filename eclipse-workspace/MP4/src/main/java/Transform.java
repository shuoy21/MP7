/**
 * A class that runs implements several simple transformations on 2D image arrays.
 * <p>
 * This file contains stub code for your image transformation methods that are called by the main
 * class. You will do your work for this MP in this file.
 * <p>
 * Note that you can make several assumptions about the images passed to your functions, both by the
 * web front end and by our testing harness:
 * <ul>
 * <li>You will not be passed empty images.</li>
 * <li>All images will have even width and height.</li>
 * </ul>
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/4/">MP4 Documentation</a>
 */
public class Transform {


    /**
     * Default amount to shift an image's position. Not used by the testing suite, so feel free to
     * change this value.
     */
    public static final int DEFAULT_POSITION_SHIFT = 16;

    /**
     * Pixel value to use as filler when you don't have any valid data. All white with complete
     * transparency. DO NOT CHANGE THIS VALUE: the testing suite relies on it.
     */
    public static final int FILL_VALUE = 0x00FFFFFF;

    /**
     * generic shift method.
     *
     * @param originalImage the image imput
     * @param amount shifted amount
     * @param isLeftshift 1 if shifted left, 0 otherwise
     * @param isRightshift 1 if shifted right, 0 otherwise
     * @param isUpshift 1 if shifted up
     * @param isDownshift 1 if shifted down
     * @return image that's shifted
     */
    public static int[][] shift(final int[][] originalImage, final int amount,
            final boolean isLeftshift, final boolean isRightshift,
            final boolean isUpshift, final boolean isDownshift) {

        int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];

        for (int x = 0; x < shiftedImage.length; x++) {
            for (int y = 0; y < shiftedImage[0].length; y++) {
                /*
                 * if (shiftedImage[i][j] == 0) {
                 * shiftedImage[i][j] = FILL_VALUE;
                 * }
                 */
                int originalX = x;
                int originalY = y;
                if (isLeftshift) {
                    originalX += amount;
                }
                if (isRightshift) {
                    originalX -= amount;
                }
                if (isUpshift) {
                    originalY += amount;
                }
                if (isDownshift) {
                    originalY -= amount;
                }
                if (originalX < originalImage.length
                        && originalY < originalImage[0].length
                        && originalX >= 0
                        && originalY >= 0) {
                    shiftedImage[x][y] = originalImage[originalX][originalY];
                } else {
                    shiftedImage[x][y] = FILL_VALUE;
                }
            }
        }
        return shiftedImage;
    }

       /* int startColumn = isLeftshift * amount;
        int endColumn = originalImage[0].length - isRightshift * amount;
        int startRow = isUpshift * amount;
        int endRow = originalImage.length - isDownshift * amount;
        int row = 0, column = 0;
        if (isLeftshift == 1) {
            row = 0;
            column = 0;
        } else if (isRightshift == 1) {
            row = 0;
            column = amount;
        } else if (isDownshift == 1) {
            row = amount;
            column = 0;
        } else if (isUpshift == 1) {
            row = 0;
            column = 0;
        } else {
            ;
        }
        for (int i = startRow, realRow = row; i < endRow; i++, realRow++) {
            for (int j = startColumn, realColumn = column; j < endColumn; j++, realColumn++) {
                shiftedImage[realRow][realColumn] = originalImage[i][j];
            }
        }*/

    /**
     * Shift the image left by the specified amount.
     * <p>
     * Any pixels shifted in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the left
     * @return the shifted image
     */

    public static int[][] shiftLeft(final int[][] originalImage, final int amount) {
        return shift(originalImage, amount, true, false, false, false);
    }

    /*
     * Shift right like above.
     */
    /**
     *
     * @param originalImage the imput image
     * @param amount the shifted amount
     * @return the shifted image
     */
    public static int[][] shiftRight(final int[][] originalImage, final int amount) {
        return shift(originalImage, amount, false, true, false, false);
    }

    /**
     * Shift up like above.
     * @param originalImage the input image
     * @param amount the shifted amount
     * @return the shifted image
     */
    public static int[][] shiftUp(final int[][] originalImage, final int amount) {
        return shift(originalImage, amount, false, false, true, false);
    }

    /**
     * Shift down like above.
     * @param originalImage the input image
     * @param amount the shifted amount
     * @return the shifted image
     */
    public static int[][] shiftDown(final int[][] originalImage, final int amount) {
        return shift(originalImage, amount, false, false, false, true);
    }
    /**
     * center image.
     * @param originalX input x
     * @param originalY input y
     * @param xRange length of x dimension
     * @param yRange length of y dimension
     * @return centered coordinates
     */
    public static double[] center(final double originalX,
            final double originalY, final double xRange, final double yRange) {
        double x = originalX - (xRange - 1) / 2.0;
        double y = originalY - (yRange - 1) / 2.0;
        return new double[] {x, y};
    }
    /**
     * undo center.
     * @param originalX input x
     * @param originalY input y
     * @param xRange length of x dimension
     * @param yRange length of y dimension
     * @return original coordinates
     */
    public static double[] undoCenter(final double originalX,
            final double originalY, final double xRange, final double yRange) {
        double x = originalX + (xRange - 1) / 2.0;
        double y = originalY + (yRange - 1) / 2.0;
        return new double[] {x, y};
    }

    /**
     * rotate the image in either direction.
     * @param originalImage input image
     * @param isLeft if rotate left
     * @param isRight if rotate right
     * @return rotated image
     */
    public static int[][] rotate(final int[][] originalImage,
            final boolean isLeft, final boolean isRight) {
        int width = originalImage.length;
        int height = originalImage[0].length;
        int[][] shiftedImage = new int[width][height];
        for (double x = 0; x < width; x++) {
            for (double y = 0; y < height; y++) {
                // center
                double[] centeredCoor = center(x, y, width, height);
                double originalX;
                double originalY;
                // rotate
                if (isLeft) {
                    originalY = centeredCoor[0];
                    originalX = -centeredCoor[1];
                } else {
                    originalX = centeredCoor[1];
                    originalY = -centeredCoor[0];
                }
                //undoCenter
                double[] coorOri = undoCenter(originalX, originalY, width, height);
                originalX = coorOri[0];
                originalY = coorOri[1];
                // fill
                if (0 <= originalX && originalX < width
                        && 0 <= originalY && originalY < height) {
                    shiftedImage[(int) x][(int) y] =
                            originalImage[(int) originalX][(int) originalY];
                } else {
                    shiftedImage[(int) x][(int) y] = FILL_VALUE;
                }
            }
        }
        return shiftedImage;
    }
    /**
     * Rotate the image left by 90 degrees around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to rotate left 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateLeft(final int[][] originalImage) {
        return rotate(originalImage, true, false);
    }

    /*
     * Rotate the image right like above.
     */
    /**
     * Rotate the image right by 90 degrees around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to rotate right 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateRight(final int[][] originalImage) {
        return rotate(originalImage, false, true);
    }
    /**
     * flip image horizontally or vertically.
     * @param originalImage input image
     * @param isVertical if flips horizontally
     * @param isHorizontal if flips vertically
     * @return fliped image
     */
    public static int[][] flip(final int[][] originalImage,
            final boolean isVertical, final boolean isHorizontal) {
        int width = originalImage.length;
        int height = originalImage[0].length;
        int[][] shiftedImage = new int[width][height];
        for (double x = 0; x < width; x++) {
            for (double y = 0; y < height; y++) {
                // center
                double[] centeredCoor = center(x, y, width, height);
                double originalX;
                double originalY;
                // rotate
                if (isHorizontal) {
                    originalY = centeredCoor[1];
                    originalX = -centeredCoor[0];
                } else {
                    originalX = centeredCoor[0];
                    originalY = -centeredCoor[1];
                }
                //undoCenter
                double[] coorOri = undoCenter(originalX, originalY, width, height);
                originalX = coorOri[0];
                originalY = coorOri[1];
                // fill
                if (0 <= originalX && originalX < width
                        && 0 <= originalY && originalY < height) {

                    shiftedImage[(int) x][(int) y] =
                            originalImage[(int) originalX][(int) originalY];
                } else {
                    shiftedImage[(int) x][(int) y] = FILL_VALUE;
                }
            }
        }
        return shiftedImage;
    }

    /*
     * Flip the image on the vertical axis across its center.
     */
    /**
     * flip the image vertically around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to flip
     * @return the flipped image
     */
    public static int[][] flipVertical(final int[][] originalImage) {
        return flip(originalImage, true, false);
    }

    /*
     * Flip the image on the horizontal axis across its center.
     */
    /**
     * flip the image honrizontally around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to flip
     * @return the flipped image
     */
    public static int[][] flipHorizontal(final int[][] originalImage) {
        return flip(originalImage, false, true);
    }

    /**
     * Default amount to shift colors by. Not used by the testing suite, so feel free to change this
     * value.
     */
    public static final int DEFAULT_COLOR_SHIFT = 32;
    /**
     *
     * @param originalImage input iamge
     * @param amount the amount to be shifted
     * @param isAlpha true if shifts on alpha
     * @param isRed true if shifts on red
     * @param isGreen true if shifts on green
     * @param isBlue true if shifts on blue
     * @return the shifted image
     */
    public static int[][] colorChange(final int[][] originalImage,
            final int amount, final boolean isAlpha, final boolean isRed,
            final boolean isGreen, final boolean isBlue) {
        int[][] changedColorImage = new int[originalImage.length][originalImage[0].length];
        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[0].length; y++) {
                int pixel = originalImage[x][y];
                final int move16 = 16;
                final int move24 = 24;
                final int move8 = 8;
                final int hex = 0xff;
                final int bound = 255;
                int alpha = (pixel >> move24) & hex;
                int blue = (pixel >> move16) & hex;
                int green = (pixel >> move8) & hex;
                int red = pixel & hex;
                if (isAlpha) {
                    alpha += amount;
                    if (alpha > bound) {
                        alpha = bound;
                    } else if (alpha < 0) {
                        alpha = 0;
                    }
                } else if (isRed) {
                    red += amount;
                    if (red > bound) {
                        red = bound;
                    } else if (red < 0) {
                        red = 0;
                    }
                } else if (isGreen) {
                    green += amount;
                    if (green > bound) {
                        green = bound;
                    } else if (green < 0) {
                        green = 0;
                    }
                } else if (isBlue) {
                    blue += amount;
                    if (blue > bound) {
                        blue = bound;
                    } else if (blue < 0) {
                        blue = 0;
                    }
                }
                int newPixel = alpha << move24 | (blue << move16) | (green << move8) | red;
                changedColorImage[x][y] = newPixel;
            }
        }
        return changedColorImage;
    }

    /**
     * Add red to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add red to
     * @param amount the amount of red to add
     * @return the recolored image
     */
    public static int[][] moreRed(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, amount, false, true, false, false);
    }

    /*
     * Remove red from the image.
     */
    /**
     * remove red to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to remove red to
     * @param amount the amount of red to remove
     * @return the recolored image
     */
    public static int[][] lessRed(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, (0 - amount), false, true, false, false);
    }

    /*
     * Add green to the image.
     */
    /**
     * add green to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add green to
     * @param amount the amount of green to remove
     * @return the recolored image
     */
    public static int[][] moreGreen(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, amount, false, false, true, false);
    }

    /*
     * Remove green from the image.
     */
    /**
     * remove green to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to remove green to
     * @param amount the amount of green to remove
     * @return the recolored image
     */
    public static int[][] lessGreen(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, (0 - amount), false, false, true, false);
    }

    /*
     * Add blue to the image.
     */
    /**
     * add blue to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add blue to
     * @param amount the amount of blue to add
     * @return the recolored image
     */
    public static int[][] moreBlue(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, amount, false, false, false, true);
    }

    /*
     * Remove blue from the image.
     */
    /**
     * remove blue to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to remove blue to
     * @param amount the amount of blue to remove
     * @return the recolored image
     */
    public static int[][] lessBlue(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, (0 - amount), false, false, false, true);
    }

    /*
     * Increase the image alpha channel.
     */
    /**
     * add alpha to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add alpha to
     * @param amount the amount of alpha to add
     * @return the recolored image
     */
    public static int[][] moreAlpha(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, amount, true, false, false, false);
    }

    /*
     * Decrease the image alpha channel.
     */
    /**
     * remove alpha to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to remove alpha to
     * @param amount the amount of alpha to remove
     * @return the recolored image
     */
    public static int[][] lessAlpha(final int[][] originalImage, final int amount) {
        return colorChange(originalImage, (0 - amount), true, false, false, false);
    }

    /**
     * The default resize factor. Not used by the testing suite, so feel free to change this value.
     */
    public static final int DEFAULT_RESIZE_AMOUNT = 2;

    /*public static int[][] expand(final int[][] originalImage, final boolean isVertical,
            final boolean isHorizontal, final int factor) {
        int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];
        int countScaleX = 0;
        int countScaleY = 0;
        for (double x = 0; x < originalImage[0].length; x++) {
            int count = 0;
            for (double y = 0; y < originalImage.length; y++) {
                double[] centeredCoor =
                        center(x, y, originalImage[0].length, originalImage.length);
                x = centeredCoor[0];
                y = centeredCoor[1];
                count++;
                double originalX = 0;
                double originalY = 0;

                if (isHorizontal && count == factor) {
                    originalX = x / factor;
                    originalY = y;
                    countScaleX++;
                    countScaleY = originalImage.length;
                } else if (isVertical && count == factor) {
                    originalX = x;
                    originalY = y / factor;
                    countScaleX = originalImage[0].length;
                    countScaleY++;
                }

                double[] origiCoor = undoCenter(originalX, originalY,
                        countScaleX ,  countScaleY);
                originalX = origiCoor[0];
                originalY = origiCoor[1];
                double[] coor = undoCenter(x, y,
                        originalImage[0].length, originalImage.length);
                x = coor[0];
                y = coor[1];
                if (0 <= originalY && originalY < originalImage.length
                        && 0 <= originalX
                        && originalX < originalImage[0].length) {
                    shiftedImage[(int) y][(int) x] =
                    originalImage[(int) originalY][(int) originalX];
                }
            }
        }
        return shiftedImage;
    }*/
    /**
     *
     * @param originalImage input image
     * @param factor factor to be expanded
     * @param isHorizontal if expand horizontally
     * @param isVertical if expand vertically
     * @return expanded image
     */
    public static int[][] expand(final int[][] originalImage,
            final int factor, final boolean isHorizontal, final boolean isVertical) {
        int width, height;
        if (isHorizontal) {
            width = originalImage.length * factor;
            height = originalImage[0].length;
        }   else {
            width = originalImage.length;
            height = originalImage[0].length * factor;
        }
        int[][] expandImage = new int[width][height];
        for (int x = 0; x < expandImage.length; x++) {
            for (int y = 0; y < expandImage[0].length; y++) {
                int originalX, originalY;
                if (isHorizontal) {
                    originalX = x / factor;
                    originalY = y;
                } else {
                    originalX = x;
                    originalY = y / factor;
                }
                expandImage[x][y] = originalImage[originalX][originalY];
            }
        }
        int[][] finalImage = new int[originalImage.length][originalImage[0].length];
        double[] centeredCoor =
                center(0, 0, originalImage.length, originalImage[0].length);
        double i = centeredCoor[0];
        double j = centeredCoor[1];
        double oriX = 0;
        double oriY = 0;
        for (int ex = 0; ex < expandImage.length; ex++) {
            for (int ey = 0; ey < expandImage[0].length; ey++) {
                double[] centeredOri =
                        center(ex, ey, expandImage.length, expandImage[0].length);
                double cx = centeredOri[0];
                double cy = centeredOri[1];
                if (cx == i && cy == j) {
                    oriX = ex;
                    oriY = ey;
                    break;
                }
            }
        }

        int originY = (int) oriY;
        for (int nx = 0; nx < finalImage.length; nx++, oriX++) {
            oriY = originY;
            for (int ny = 0; ny < finalImage[0].length; ny++, oriY++) {
                finalImage[nx][ny] = expandImage[(int) oriX][(int) oriY];
            }
        }
        return finalImage;
    }
    /**
     * Shrink in the vertical axis around the image center.
     * <p>
     * An amount of 2 will result in an image that is half its original height. An amount of 3 will
     * result in an image that's a third of its original height. Any pixels shrunk in from off
     * screen should be filled with FILL_VALUE. This function <i>does not modify the original
     * image</i>.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkVertical(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Expand in the vertical axis around the image center.
     */
    /**
     * expand the image vertically.
     * @param originalImage the input image
     * @param amount the amount to be expanded
     * @return the expanded image
     */
    public static int[][] expandVertical(final int[][] originalImage, final int amount) {
        return expand(originalImage, amount, false, true);
    }

    /*
     * Shrink in the horizontal axis around the image center.
     */
    /**
     * shrink the image horizontally.
     * @param originalImage the input image
     * @param amount the amount to be shrinked
     * @return the shrinked image
     */
    public static int[][] shrinkHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Expand in the horizontal axis around the image center.
     */
    /**
     * expand the image horizontally.
     * @param originalImage the input image
     * @param amount the amount to be expanded
     * @return the expanded image
     */
    public static int[][] expandHorizontal(final int[][] originalImage, final int amount) {
        return expand(originalImage, amount, true, false);
    }

    /**
     * Remove a green screen mask from an image.
     * <p>
     * This function should remove primarily green pixels from an image and replace them with
     * transparent pixels (FILL_VALUE), allowing you to achieve a green screen effect. Obviously
     * this function will destroy pixels, but it <i>does not modify the original image</i>.
     * <p>
     * While this function is tested by the test suite, only extreme edge cases are used. Getting it
     * work work will with real green screen images is left as a challenge for you.
     *
     * @param originalImage the image to remove a green screen from
     * @return the image with the green screen removed
     */
    public static int[][] greenScreen(final int[][] originalImage) {
        int[][] changedColorImage = new int[originalImage.length][originalImage[0].length];
        final int green = 0xff00ff00;
        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[0].length; y++) {
                int pixel = originalImage[x][y];
                if (pixel == green) {
                    pixel = FILL_VALUE;
                }
                changedColorImage[x][y] = pixel;
            }
        }
        return changedColorImage;
    }

    /**
     * A wild and mysterious image transform.
     * <p>
     * You are free to implement this in any way you want. It is not tested rigorously by the test
     * suite, but it should do something (change the original image) and <i>not modify the original
     * image</i>.
     * <p>
     * Call this function mystery. It should take only the original image as a single argument and
     * return a modified image.
     *
     * @param originalImage the image to perform a strange and interesting transform on
     * @return the image transformed in wooly and frightening ways
     */
    public static int[][] mystery(final int[][] originalImage) {
        int[][] changedImage = new int[originalImage.length][originalImage[0].length];
        final int shiftedValue = 100;
        final int caseNum = 3;
        int switchNum = (int) (Math.random() * caseNum) + 1;
        switch (switchNum) {
            case 1:
                changedImage = moreRed(originalImage, shiftedValue);
                break;
            case 2:
                changedImage = moreGreen(originalImage, shiftedValue);
                break;
            case caseNum:
                changedImage = moreBlue(originalImage, shiftedValue);
                break;
            default:
                changedImage = originalImage;

        }
        /*int[][] effect1 = moreRed(originalImage, shiftedValue);
        int[][] effect2 = moreGreen(originalImage, shiftedValue);
        int[][] effect3 = moreBlue(originalImage, shiftedValue);
        int[][][] effects = {effect1, effect2, effect3, originalImage};
        final int range = 3;
        int[][] changedImage = effects[(int) (Math.random() * range)];*/
        return changedImage;
    }
}