/**
 * Created by vepa on 21/9/17.
 */
var gulp = require('gulp')
var gutil = require('gulp-util')
var jshint = require('gulp-jshint')
var concat = require('gulp-concat')
var sourcemaps = require('gulp-sourcemaps')
var uglify = require('gulp-uglify');
var minifyCSS = require('gulp-clean-css');

var buildsources = [
    './node_modules/jquery/dist/jquery.js'
    , './node_modules/jquery-ui-dist/jquery-ui.js'
    , './node_modules/bootstrap/dist/js/bootstrap.js'
    , './node_modules/angular/angular.js'
    , './node_modules/angular-animate/angular-animate.js'
    , './node_modules/angular-aria/angular-aria.js'
    , './node_modules/angular-material/angular-material.js'
    , './node_modules/angular-messages/angular-messages.js'
    , './node_modules/angular-route/angular-route.js'
    , './node_modules/ng-file-upload/dist/ng-file-upload-all.js'
    , './node_modules/underscore/underscore.js'
    , './node_modules/jsog/lib/JSOG.js'
    , './src/main/resources/static/js/ps-app.js'
    , './src/main/resources/static/js/ps-scripts.js'
];

var depend_styles = [
    './node_modules/bootstrap/dist/css/bootstrap.css'
    , './node_modules/jquery-ui-dist/jquery-ui.css'
    , './node_modules/angular-material/angular-material.css'
    , './node_modules/font-awesome/css/font-awesome.min.css'
    , './src/main/resources/static/css/styles.css'
];

var dest = './src/main/resources/static/js';
var css_dest = './src/main/resources/static/css/module';

var analyzeSources = ['src/main/resources/static/**/*.js' ,'!src/main/resources/static/js/**/*'];

gulp.task('default', ['watch', 'build-js', 'copy-css']);

gulp.task('watch', function() {
    gulp.watch(buildsources, ['build-js']);
    gulp.watch(depend_styles, ['copy-css']);
});

gulp.task('jshint', function() {
    return gulp.src(analyzeSources)
        .pipe(jshint())
        .pipe(jshint.reporter('jshint-stylish'));
});

gulp.task('build-js', function() {
    return gulp.src(buildsources, { base: 'src/main/resources/static/' })
        .pipe(sourcemaps.init())
        .pipe(concat('bundle.js'))
        .pipe(gutil.env.type === 'production' ? uglify() : gutil.noop())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(dest));
});

gulp.task('copy-css', function() {
    return gulp.src(depend_styles, { base: 'src/main/resources/static/' })
        .pipe(sourcemaps.init())
        .pipe(concat('styles.css'))
        .pipe(gutil.env.type === 'production' ? minifyCSS() : gutil.noop())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(css_dest));
});
